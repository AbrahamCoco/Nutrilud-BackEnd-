import React, { useEffect, useState } from "react";
import { Container } from "react-bootstrap";
import { useParams } from "react-router-dom";

const Consulta = () => {
    const { id } = useParams();
    const [paciente, setPaciente] = useState(null);
    const [consulta, setConsulta] = useState([]);
    const [datosFormulario, setDatosFormulario] = useState({
        peso: '',
        estatura: '',
        imc: '',
        porcentaje_grasa: '',
        porcentaje_musculo: '',
        pliegue_tricipital: '',
        pliegue_bicipital: '',
        circunferencia_cintura: '',
        circunferencia_cadera: '',
        fecha_medicion: '',
        siguiente_consulta: ''
    });

    useEffect(() => {
        loadPaciente();
        loadDatosConsulta();
    }, [id]);

    const loadPaciente = async () => {
        try {
            const response = await axios.get(`/api/v1/paciente/${id}`);
            setPaciente(response.data.paciente);
            console.log(response.data.paciente);
        } catch (error) {
            console.log(error);
        }
    };

    const calcularEdad = (fechaNacimiento) => {
        const fechaNac = new Date(fechaNacimiento);
        const hoy = new Date();
        const edad = hoy.getFullYear() - fechaNac.getFullYear();

        if (hoy.getMonth() < fechaNac.getMonth() || (hoy.getMonth() === fechaNac.getMonth() && hoy.getDate() < fechaNac.getDate())) {
            return edad - 1;
        }

        return edad;
    };

    const loadDatosConsulta = async () => {
        try {
            const response = await axios.get(`/api/v1/consultadatos/${id}`);
            console.log(response.data);
            setConsulta(response.data.consulta || []);
            console.log(response.data.consulta);
        } catch (error) {
            console.log(error);
        }
    };

    const handleGuardarDatos = async (event) => {
        event.preventDefault();
        try {
            const response = await axios.post(`/api/v1/insertardatos/${id}`, datosFormulario, {
                headers: {
                    'Content-Type': 'application/json'
                }
            });
            console.log(response.data);

            setDatosFormulario({
                peso: '',
                estatura: '',
                imc: '',
                porcentaje_grasa: '',
                porcentaje_musculo: '',
                pliegue_tricipital: '',
                pliegue_bicipital: '',
                circunferencia_cintura: '',
                circunferencia_cadera: '',
                fecha_medicion: '',
                siguiente_consulta: ''
            });
        } catch (error) {
            console.log(error);
        }
    };

    if (!paciente) {
        return (
            <div className="container">
                <h1>Cargando paciente...</h1>
            </div>
        );
    }

    return (
        <Container>
            <h1>Consulta</h1>
            <h2>Datos del paciente</h2>
            <div className="row">
                <div className="col-sm-12">
                    <div className="table-responsive">
                        <table className="table table-striped table-bordered">
                            <thead className="table-dark text-center">
                                <tr>
                                    <th>Nombre</th>
                                    <th>Alergias</th>
                                    <th>Sexo</th>
                                    <th>Edad</th>
                                    <th>Correo</th>
                                    <th>Telefono</th>
                                </tr>
                            </thead>
                            <tbody>
                                <tr>
                                    <td><strong>{paciente.user.nombre} {paciente.user.primer_apellido} {paciente.user.segundo_apellido}</strong></td>
                                    <td>{paciente.alergias}</td>
                                    <td>{paciente.sexo}</td>
                                    <td>{calcularEdad(paciente.fecha_nacimiento)} años</td>
                                    <td>{paciente.user.correo}</td>
                                    <td>{paciente.telefono}</td>
                                </tr>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
            <h2>Datos de consultas anteriores</h2>
            <div className="row">
                <div className="col-sm-12">
                    <div className="table-responsive">
                        <table className="table table-striped table-bordered align-middle">
                            <thead className="text-center table-dark">
                                <tr className="align-middle">
                                    <th rowSpan={2}>Fecha de medicion</th>
                                    <th rowSpan={2}>Peso</th>
                                    <th rowSpan={2}>Estatura</th>
                                    <th colSpan={2}>Porcentaje</th>
                                    <th rowSpan={2}>IMC</th>
                                    <th colSpan={2}>Circunferencia</th>
                                    <th colSpan={2}>Pliegue</th>
                                </tr>
                                <tr>
                                    <th>Grasa</th>
                                    <th>Musculo</th>
                                    <th>Cintura</th>
                                    <th>Cadera</th>
                                    <th>Bicipital</th>
                                    <th>Tricipital</th>
                                </tr>
                            </thead>
                            <tbody>
                                {Array.isArray(consulta) && consulta.slice(-3).map((datos) => (
                                    <tr key={datos.id}>
                                        <td>{new Date(datos.fecha_medicion.split(' ')[0]).toLocaleDateString('es-ES', { year: 'numeric', month: 'long', day: 'numeric' })}</td>
                                        <td>{datos.peso} kg</td>
                                        <td>{datos.estatura} cm</td>
                                        <td>{datos.porcentaje_grasa} %</td>
                                        <td>{datos.porcentaje_musculo} %</td>
                                        <td>{datos.imc}</td>
                                        <td>{datos.circunferencia_cintura} cm</td>
                                        <td>{datos.circunferencia_cadera} cm</td>
                                        <td>{datos.pliegue_bicipital}</td>
                                        <td>{datos.pliegue_tricipital}</td>
                                    </tr>
                                ))}
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
            <h2>Agregar datos de consulta actual</h2>
            <form onSubmit={handleGuardarDatos}>
                <div className="row">
                    <div className="col-sm-3">
                        <label htmlFor="peso" className="form-label">Peso</label>
                        <input type="number" step="0.001" className="form-control" name="peso" value={datosFormulario.peso} onChange={(e) => setDatosFormulario({ ...datosFormulario, peso: e.target.value })} />
                        {/* <label htmlFor="imc" className="form-label">IMC</label>
                        <input type="number" step="0.001" className="form-control" name="imc" value={datosFormulario.imc} onChange={(e) => setDatosFormulario({ ...datosFormulario, imc: e.target.value })} /> */}
                        <label htmlFor="pliegue_tricipital" className="form-label">Pliegue tricipital</label>
                        <input type="number" step="0.001" className="form-control" name="pliegue_tricipital" value={datosFormulario.pliegue_tricipital} onChange={(e) => setDatosFormulario({ ...datosFormulario, pliegue_tricipital: e.target.value })} />
                    </div>
                    <div className="col-sm-3">
                        <label htmlFor="estatura" className="form-label">Estatura</label>
                        <input type="number" step="0.001" className="form-control" name="estatura" value={datosFormulario.estatura} onChange={(e) => setDatosFormulario({ ...datosFormulario, estatura: e.target.value })} />
                        <label htmlFor="circunferencia_cintura" className="form-label">Circunferencia de cintura</label>
                        <input type="number" step="0.001" className="form-control" name="circunferencia_cintura" value={datosFormulario.circunferencia_cintura} onChange={(e) => setDatosFormulario({ ...datosFormulario, circunferencia_cintura: e.target.value })} />
                    </div>
                    <div className="col-sm-3">
                        {/* <label htmlFor="porcentaje_grasa" className="form-label">Porcentaje de grasa</label>
                        <input type="number" step="0.001" className="form-control" name="porcentaje_grasa" value={datosFormulario.porcentaje_grasa} onChange={(e) => setDatosFormulario({ ...datosFormulario, porcentaje_grasa: e.target.value })} /> */}
                        <label htmlFor="circunferencia_cadera" className="form-label">Circunferencia de cadera</label>
                        <input type="number" step="0.001" className="form-control" name="circunferencia_cadera" value={datosFormulario.circunferencia_cadera} onChange={(e) => setDatosFormulario({ ...datosFormulario, circunferencia_cadera: e.target.value })} />
                        <label htmlFor="fecha_siguiente_consulta" className="form-label">Fecha de siguiente consulta</label>
                        <input type="datetime-local" className="form-control" name="siguiente_consulta" value={datosFormulario.siguiente_consulta} onChange={(e) => setDatosFormulario({ ...datosFormulario, siguiente_consulta: e.target.value })} />
                    </div>
                    <div className="col-sm-3">
                        {/* <label htmlFor="porcentaje_musculo" className="form-label">Porcentaje de músculo</label>
                        <input type="number" step="0.001" className="form-control" name="porcentaje_musculo" value={datosFormulario.porcentaje_musculo} onChange={(e) => setDatosFormulario({ ...datosFormulario, porcentaje_musculo: e.target.value })} /> */}
                        <label htmlFor="pliegue_bicipital" className="form-label">Pliegue bicipital</label>
                        <input type="number" step="0.001" className="form-control" name="pliegue_bicipital" value={datosFormulario.pliegue_bicipital} onChange={(e) => setDatosFormulario({ ...datosFormulario, pliegue_bicipital: e.target.value })} />
                        <label htmlFor="fecha_medicion" className="form-label">Fecha de medicion</label>
                        <input type="date" className="form-control" name="fecha_medicion" value={datosFormulario.fecha_medicion} onChange={(e) => setDatosFormulario({ ...datosFormulario, fecha_medicion: e.target.value })} />
                        <div className="text-center my-4">
                            <button className="btn btn-primary" type="submit">Guardar datos</button>
                        </div>
                    </div>
                </div>
            </form>
        </Container>
    );
};

export default Consulta;
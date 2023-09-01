import React, { useState } from 'react';
import 'bootstrap/dist/css/bootstrap.min.css';
import '../../css/app.css';
import axios from 'axios';

const RegistroForm = () => {
    const [nombre, setNombre] = useState('');
    const [primer_apellido, setPrimerApellido] = useState('');
    const [segundo_apellido, setSegundoApellido] = useState('');
    const [correo, setCorreo] = useState('');
    const [contrasenia, setContrasenia] = useState('');
    const [selectedImage, setSelectedImage] = useState(null);
    const [descripcion, setDescripcion] = useState('');
    const [telefono, setTelefono] = useState('');
    const [direccion, setDireccion] = useState('');
    const [cedula_profesional, setCedulaProfesional] = useState('');
    const [selectedRole, setSelectedRole] = useState(null);
    const [id_paciente, setIdPaciente] = useState(null);
    const [fecha_nacimiento, setFechaNacimiento] = useState('');
    const [sexo, setSexo] = useState('');
    const [alergias, setAlergias] = useState('');

    const handleImageChange = (e) => {
        const file = e.target.files[0];
        const reader = new FileReader();

        reader.onloadend = () => {
            setSelectedImage(reader.result);
        }

        if (file) {
            reader.readAsDataURL(file);
        }
    };

    const handleRoleChange = (event) => {
        setSelectedRole(parseInt(event.target.value));
    };

    const handleRegister = async () => {
        try {
            const response = await axios.post('/api/v1/auth/register', {
                nombre,
                primer_apellido,
                segundo_apellido,
                correo,
                contrasenia,
            });
            console.log(response.data);

            setNombre('');
            setPrimerApellido('');
            setSegundoApellido('');
            setCorreo('');
            setContrasenia('');

            setSelectedRole(null);
        }catch(error) {
            console.error('Error', error);
        }
    };

    return (
        <div className='container'>
            <form>
                <div className="row">
                    <div className="col-sm-3">
                        {selectedImage && <img src={selectedImage} className='img-fluid imagen' alt='Previsualización' />}
                    </div>
                    <div className="col-sm-9">
                        <div className="mb-2">
                            <label htmlFor="imagen" className="form-label">Imagen</label>
                            <input type="file" className="form-control" id="imagen" onChange={handleImageChange} />
                        </div>
                    </div>
                </div>
                <div className="row">
                    <div className="col-sm-6">
                        <div className="mb-2">
                            <label htmlFor="nombre" className="form-label">Nombre</label>
                            <input type="text" className="form-control" id="nombre" value={nombre} onChange={(e) => setNombre(e.target.value)} />
                        </div>
                        <div className="mb-2">
                            <label htmlFor="primer_apellido" className="form-label">Primer Apellido</label>
                            <input type="text" className="form-control" id="primer_apellido" value={primer_apellido} onChange={(e) => setPrimerApellido(e.target.value)} />
                        </div>
                        <div className="mb-2">
                            <label htmlFor="segundo_apellido" className="form-label">Segundo Apellido</label>
                            <input type="text" className="form-control" id="segundo_apellido" value={segundo_apellido} onChange={(e) => setSegundoApellido(e.target.value)} />
                        </div>
                    </div>
                    <div className="col-sm-6">
                        <div className="mb-2">
                            <label htmlFor="correo" className="form-label">Correo Electrónico</label>
                            <input type="email" className="form-control" id="correo" value={correo} onChange={(e) => setCorreo(e.target.value)} />
                        </div>
                        <div className="mb-2">
                            <label htmlFor="contrasenia" className="form-label">Contraseña</label>
                            <input type="password" className="form-control" id="contrasenia" value={contrasenia} onChange={(e) => setContrasenia(e.target.value)} />
                        </div>
                        <label htmlFor="tipoUsuario" className='form-label'>Tipo de usuario</label>
                        <div className="mb-2">
                            <div className="form-check-inline">
                                <label htmlFor="admin-bill" className="form-check-label">
                                    <input type="radio" className='form-check-input bill' name='bill' id='admin-bill' value={1} checked={selectedRole === 1} onChange={handleRoleChange}/>Administrador
                                </label>
                            </div>
                            <div className="form-check-inline">
                                <label htmlFor="nutriologo-bill" className="form-check-label">
                                    <input type="radio" className='form-check-input bill' name='bill' id='nutriologo-bill' value={2} checked={selectedRole === 2} onChange={handleRoleChange} />Nutriologo
                                </label>
                            </div>
                            <div className="form-check-inline">
                                <label htmlFor="paciente-bill" className="form-check-label">
                                    <input type="radio" className='form-check-input bill' name='bill' id='paciente-bill' value={3} checked={selectedRole === 3} onChange={handleRoleChange} />Paciente
                                </label>
                            </div>
                        </div>
                    </div>
                </div>
                    {selectedRole === 1 && (
                        <div id='admin' className='row mb-2'>
                            <div className="col-sm-6">
                                <label htmlFor="descripcion" className='form-label'>Descripcion</label>
                                <input type="text" className='form-control' id='descripcion' value={descripcion} onChange={(e) => setDescripcion(e.target.value)} />
                            </div>
                            <div className="col-sm-6">
                                <label htmlFor="telefono" className='form-label'>Telefono</label>
                                <input type="text" className='form-control' id='telefono' value={telefono} onChange={(e) => setTelefono(e.target.value)} />
                            </div>
                        </div>
                    )}
                    {selectedRole === 2 && (
                        <div id="nutriologo" className='row mb-2'>
                            <div className="col-sm-6">
                                <label htmlFor="descripcion" className='form-label'>Descripcion</label>
                                <input type="text" className='form-control' id='descripcion' value={descripcion} onChange={(e) => setDescripcion(e.target.value)} />
                                <label htmlFor="direccion" className='form-label'>Direccion</label>
                                <input type="text" className='form-control' id='direccion' value={direccion} onChange={(e) => setDireccion(e.target.value)} />
                            </div>
                            <div className="col-sm-6">
                                <label htmlFor="telefono" className='form-label'>Telefono</label>
                                <input type="text" className='form-control' id='telefono' value={telefono} onChange={(e) => setTelefono(e.target.value)} />
                                <label htmlFor="cedula_profesional" className='form-label'>Cedula Profesional</label>
                                <input type="text" className='form-control' id='cedula_profesional' value={cedula_profesional} onChange={(e) => setCedulaProfesional(e.target.value)} />
                            </div>
                        </div>    
                    )}
                    {selectedRole === 3 && (
                        <div id="paciente" className='row mb-2'>
                            <div className="col-sm-6">
                                <label htmlFor="id_paciente" className='form-label'>ID Paciente</label>
                                <input type="text" className='form-control' id='id_paciente' value={id_paciente} onChange={(e) => setIdPaciente(e.target.value)} />
                                <label htmlFor="fecha_nacimiento" className='form-label'>Fecha de Nacimiento</label>
                                <input type="date" className='form-control' id='fecha_nacimiento' value={fecha_nacimiento} onChange={(e) => setFechaNacimiento(e.target.value)} />
                            </div>
                            <div className="col-sm-6">
                                <label htmlFor="sexo" className='form-label'>Sexo</label>
                                <input type="text" className='form-control' id='sexo' value={sexo} onChange={(e) => setSexo(e.target.value)} />
                                <label htmlFor="alergias" className='form-label'>Alergias</label>
                                <input type="text" className='form-control' id='alergias' value={alergias} onChange={(e) => setAlergias(e.target.value)} />
                            </div>
                        </div>
                    )}
                <button type="button" className="btn btn-success" onClick={handleRegister}>Registrarse</button>
            </form>
        </div>
    )
}

export default RegistroForm;
import axios from "axios";
import React, { useEffect, useState } from "react";
import { Container, Table } from "react-bootstrap";
import { Link } from "react-router-dom";

const Pacientes = () => {
    const [pacientes, setPacientes] = useState([]);

    useEffect(() => {
        loadPacientes();
    }, []);

    const loadPacientes = async () => {
        try {
            const response = await axios.get('/api/v1/pacientes');
            setPacientes(response.data.pacientes);
            console.log(response.data.pacientes);
        } catch (error) {
            console.log(error);
        }
    }

    return (
        <Container>
            <h1>Pacientes</h1>
            <Table striped bordered hover >
                <thead className="text-center">
                    <tr>
                        <th>Nombre</th>
                        <th>Sexo</th>
                        <th>Correo</th>
                        <th>Telefono</th>
                        <th>Dar consulta</th>
                        <th>Modificar</th>
                        <th>Eliminar</th>
                    </tr>
                </thead>
                <tbody>
                    {pacientes.map((paciente) => (
                        <tr key={paciente.id}>
                            <td>{paciente.user.nombre} {paciente.user.primer_apellido} {paciente.user.segundo_apellido}</td>
                            <td>{paciente.sexo}</td>
                            <td>{paciente.user.correo}</td>
                            <td>{paciente.telefono}</td>
                            <td className="text-center">
                                <Link to={`/nutriologo/consulta/${paciente.id}`}>
                                    <div>
                                        <button className="btn btn-success">Consulta</button>
                                    </div>
                                </Link>
                            </td>
                            <td className="text-center">
                                <Link to={`/modificar-paciente/${paciente.id}`}>
                                    <div>
                                        <button className="btn btn-primary">Modificar</button>
                                    </div>
                                </Link>
                            </td>
                            <td className="text-center">
                                <Link to={`/eliminar-paciente/paciente=${paciente.id}`}>
                                    <div>
                                        <button className="btn btn-danger">Eliminar</button>
                                    </div>
                                </Link>
                            </td>
                        </tr>
                    ))}
                </tbody>
            </Table>
        </Container>
    );
};

export default Pacientes;
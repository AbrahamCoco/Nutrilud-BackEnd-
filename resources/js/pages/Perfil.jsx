import React, { useEffect, useState } from "react";
import axios from "axios";
import { Container, Image, Row, Col } from "react-bootstrap";

const Perfil = () => {
    const [perfilData, setPerfilData] = useState({});
    const [isLoading, setIsLoading] = useState(true);
    const [error, setError] = useState(null);

    useEffect(() => {
        const nutriologoId = localStorage.getItem("nutriologo_id");
        const adminId = localStorage.getItem("admin_id");
        const pacienteId = localStorage.getItem("paciente_id");

        if (nutriologoId) {
            axios.get(`/api/v1/auth/user/${nutriologoId}`)
                .then((response) => {
                    console.log(response.data.data);
                    setPerfilData(response.data.data);
                    setIsLoading(false);
                })
                .catch((error) => {
                    setError(error);
                    setIsLoading(false);
                });
        } else if (adminId) {
            axios.get(`/api/v1/auth/user/${adminId}`)
                .then((response) => {
                    console.log(response.data.data);
                    setPerfilData(response.data.data);
                    setIsLoading(false);
                })
                .catch((error) => {
                    setError(error);
                    setIsLoading(false);
                });
        } else if (pacienteId) {
            axios.get(`/api/v1/auth/user/${pacienteId}`)
                .then((response) => {
                    console.log(response.data.data);
                    setPerfilData(response.data.data);
                    setIsLoading(false);
                })
                .catch((error) => {
                    setError(error);
                    setIsLoading(false);
                });
        } else {
            setError(new Error("El ID del nutriólogo no está definido en el almacenamiento local."));
            setIsLoading(false);
        }
    }, []);

    if (isLoading) {
        return (
            <div className="container">
                <h1>Cargando...</h1>
            </div>
        );
    }

    if (error) {
        return (
            <div className="container">
                <h1>Error: {error.message}</h1>
            </div>
        );
    }

    return (
        <Container>
            <h1>Perfil</h1>
            <Row>
                <Col md={3}>
                    <Image src={perfilData.foto} alt={perfilData.user.nombre} fluid roundedCircle />
                </Col>
                <Col md={9}>
                    <h4>Nombre</h4>
                    <h5>{perfilData.user.nombre} {perfilData.user.primer_apellido} {perfilData.user.segundo_apellido} </h5>
                    <h4>Correo</h4>
                    <h5>{perfilData.user.correo}</h5>
                    <h4>Telefono</h4>
                    <h5>{perfilData.telefono}</h5>
                </Col>
            </Row>
            <Row>
                <Col md={6}>
                    <h4>Descripcion</h4>
                    <h5>{perfilData.descripcion}</h5>
                    <h4>Direccion</h4>
                    <h5>{perfilData.direccion}</h5>
                </Col>
                <Col md={6}>
                    <h4>Cedula profesional</h4>
                    <h5>{perfilData.cedula_profesional}</h5>
                </Col>
            </Row>
        </Container>
    );
}

export default Perfil;
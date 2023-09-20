import React, { useState } from "react";
import { Link } from "react-router-dom";
import 'bootstrap/dist/css/bootstrap.min.css';
import { Modal } from "react-bootstrap";
import axios from "axios";

const Navbar = () => {
    const [isLoggedIn, setIsLoggedIn] = useState(false);

    const handleLogin = () => {
        const usuario = document.getElementById('usuario').value;
        const contrasenia = document.getElementById('contrasenia').value;

        axios.post('/api/v1/auth/login', {
            usuario: usuario,
            contrasenia: contrasenia
        })
            .then(response => {
                console.log(response.data);
                localStorage.setItem('token', response.data.token);
                localStorage.setItem('admin_id', response.data.admin_id ?? null);
                localStorage.setItem('nutriologo_id', response.data.nutriologo_id ?? null);
                localStorage.setItem('paciente_id', response.data.paciente_id ?? null);
                localStorage.setItem('trol_id', response.data.trol_id);
                closeModal();
                setIsLoggedIn(true);
            })
            .catch(error => {
                console.log('Error', error);
            });
    };

    const handleLogout = async () => {
        try {
            const response = await axios.post('/api/v1/auth/logout', {}, {
                headers: {
                    Authorization: `Bearer ${localStorage.getItem('token')}`
                }
            });

            localStorage.removeItem('token');
            localStorage.removeItem('nutriologo_id');
            setIsLoggedIn(false);
            console.log('Cerro sesion correctamente');
        } catch (error) {
            if (error.response && error.response.status === 401) {
                // El token es inválido
                console.log('El token es inválido. Necesita iniciar sesión nuevamente');
            } else {
                // Otro error
                console.log('Error no cerro sesion', error);
            }
        }
    };

    const [showModal, setShowModal] = useState(false);

    const openModal = () => {
        setShowModal(true);
    };

    const closeModal = () => {
        setShowModal(false);
    };

    return (
        <>
            <nav className="navbar navbar-expand-lg navbar-success bg-success">
                <div className="container">
                    <div className="row lg-6">
                        <ul className="nav">
                            <Link to="/" className="nav-link text-white">Nutrilud</Link>
                            <Link to="/contacto" className="nav-link text-white">Contacto</Link>
                        </ul>
                    </div>
                    <div className="row lg-6">
                        <ul className="nav flex-row-reverse">
                            {isLoggedIn ? (
                                <>
                                    <li className="nav-item ms-2">
                                        <div className="btn-group">
                                            <button type="button" className="btn btn-primary dropdown-toggle" data-bs-toggle="dropdown" aria-expanded="false">
                                                Opciones
                                            </button>
                                            <ul className="dropdown-menu">
                                                <li><Link to="/agregar-articulo" className="dropdown-item">Agregar articulo</Link></li>
                                                <li><a className="dropdown-item" href="#">Opcion 2</a></li>
                                                <li><a className="dropdown-item" href="#">Opcion 3</a></li>
                                                <li><hr className="dropdown-divider" /></li>
                                                <li><a className="dropdown-item" href="#" onClick={handleLogout}>Cerrar Sesión</a></li>
                                            </ul>
                                        </div>
                                    </li>
                                    <li className="nav-item ms-2">
                                        <Link to="/perfil" className="nav-link text-white">Perfil</Link>
                                    </li>
                                </>
                            ) : (
                                <>
                                    <li className="nav-item ms-2">
                                        <button className="btn btn-primary">
                                            <Link to="/registro" className="text-white text-decoration-none">
                                                Registrarse
                                            </Link>
                                        </button>
                                    </li>
                                    <li className="nav-item ms-2">
                                        <button className="btn btn-primary" onClick={openModal}>Iniciar Sesión</button>
                                    </li>
                                </>
                            )}
                        </ul>
                    </div>
                </div>
            </nav>

            <Modal show={showModal} onHide={closeModal}>
                <Modal.Header closeButton>
                    <Modal.Title>Iniciar Sesion</Modal.Title>
                </Modal.Header>
                <Modal.Body>
                    <label htmlFor="usuario">Usuario</label>
                    <input type="text" name="usuario" id="usuario" className="form-control" />
                    <label htmlFor="contrasenia">Contraseña</label>
                    <input type="password" name="contrasenia" id="contrasenia" className="form-control" />
                </Modal.Body>
                <Modal.Footer>
                    <button className="btn btn-secondary" onClick={closeModal}>
                        Cerrar
                    </button>
                    <button className="btn btn-primary" onClick={handleLogin}>
                        Iniciar Sesión
                    </button>
                </Modal.Footer>
            </Modal>
        </>
    );
}

export default Navbar;
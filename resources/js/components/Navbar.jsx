import React from "react";
import {Link } from "react-router-dom";
import 'bootstrap/dist/css/bootstrap.min.css';

const Navbar = () => {
    return (
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
                        <li className="nav-item ms-2">
                            <button className="btn btn-primary">
                                <Link to="/registro" className="text-white text-decoration-none">
                                    Registrarse
                                </Link>
                            </button>
                        </li>
                        <li className="nav-item ms-2">
                            <button className="btn btn-primary">Iniciar Sesíon</button>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>
    );
}

export default Navbar;
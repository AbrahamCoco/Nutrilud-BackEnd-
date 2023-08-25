import React from "react";

const Navbar = () => {
    return (
        <nav className="navbar navbar-expand-lg navbar-success bg-success">
            <div className="container">
                <div className="row lg-6">
                    <ul className="nav">
                        <a href="#" className="nav-link text-dark fw-bold">Nutrilud</a>
                        <a href="#" className="nav-link text-dark">Contacto</a>
                    </ul>
                </div>
                <div className="row lg-6">
                    <ul className="nav flex-row-reverse">
                        <li className="nav-item ms-2">
                            <button className="btn btn-primary">Registrarse</button>
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
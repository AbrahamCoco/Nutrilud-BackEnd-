import React from 'react';
import ReactDOM from 'react-dom/client';
import 'bootstrap/dist/css/bootstrap.min.css';
import Navbar from './components/Navbar.jsx';
import Home from './pages/Home.jsx';
import { BrowserRouter, Routes, Route } from 'react-router-dom';
import RegistroForm from './pages/Registro.jsx';
import DetalleArticulo from './pages/DetalleArticulo.jsx';

const App = () => {
    return (
        <>
            <Navbar />
            <Routes>
                <Route path="/" element={<Home />} />
                <Route path="/registro" element={<RegistroForm />} />
                <Route path="/agregar-articulo" element={<h1>Contacto</h1>} />
                <Route path='/articulo/:id' element={<DetalleArticulo />} />
            </Routes>
        </>
    );
}

export default App;

if (document.getElementById('root')) {
    const root = ReactDOM.createRoot(document.getElementById('root'));
    root.render(
        <React.StrictMode>
            <BrowserRouter>
                <App />
            </BrowserRouter>
        </React.StrictMode>
    );
}
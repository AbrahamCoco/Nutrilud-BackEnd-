import React from 'react';
import ReactDOM from 'react-dom/client';
import 'bootstrap/dist/css/bootstrap.min.css';
import { BrowserRouter, Routes, Route } from 'react-router-dom';
import Navbar from './components/Navbar.jsx';
import Home from './pages/Home.jsx';
import RegistroForm from './pages/Registro.jsx';
import DetalleArticulo from './pages/DetalleArticulo.jsx';
import AgregarArticulo from './pages/AgregarArticulo.jsx';
import Perfil from './pages/Perfil.jsx';
import Contacto from './pages/Contacto.jsx';
import Calendar from './pages/Calendar.jsx';

const App = () => {
    return (
        <>
            <Navbar />
            <Routes>
                <Route path="/" element={<Home />} />
                <Route path="/registro" element={<RegistroForm />} />
                <Route path="/perfil" element={<Perfil />} />
                <Route path="/agregar-articulo" element={<AgregarArticulo />} />
                <Route path="/calendar" element={<Calendar />} />
                <Route path='/articulo/:id' element={<DetalleArticulo />} />
                <Route path='/contacto' element={<Contacto />} />
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
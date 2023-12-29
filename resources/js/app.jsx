import React from 'react';
import ReactDOM from 'react-dom/client';
import 'bootstrap/dist/css/bootstrap.min.css';
import { BrowserRouter, Routes, Route } from 'react-router-dom';
import Navbar from './components/Navbar.jsx';
import Footer from './components/Footer.jsx';
import Home from './pages/Home.jsx';
import RegistroForm from './pages/Registro.jsx';
import DetalleArticulo from './pages/DetalleArticulo.jsx';
import AgregarArticulo from './pages/AgregarArticulo.jsx';
import Perfil from './pages/Perfil.jsx';
import Contacto from './pages/Contacto.jsx';
import Calendar from './pages/Calendar.jsx';
import Pacientes from './pages/Pacientes.jsx';
import Consulta from './pages/Consulta.jsx';

const App = () => {
    return (
        <>
            <Navbar />
            <Routes>
                <Route path="/" element={<Home />} />
                <Route path="/registro" element={<RegistroForm />} />
                <Route path="/perfil" element={<Perfil />} />
                <Route path="/nutriologo/agregar-articulo" element={<AgregarArticulo />} />
                <Route path="/nutriologo/agenda" element={<Calendar />} />
                <Route path="/nutriologo/pacientes" element={<Pacientes />} />
                <Route path="/nutriologo/consulta/:id" element={<Consulta />} />
                <Route path='/articulo/:id' element={<DetalleArticulo />} />
                <Route path='/contacto' element={<Contacto />} />
            </Routes>
            <Footer />
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
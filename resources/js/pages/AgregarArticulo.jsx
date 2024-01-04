import React from "react";
import axios from "axios";

const AgregarArticulo = () => {
    const handleAgregarArticulo = () => {
        const titulo = document.getElementById('titulo').value;
        const contenido = document.getElementById('contenido').value;

        // Paso 1: Verifica los datos de la solicitud
        console.log(`Titulo: ${titulo}`);
        console.log(`Contenido: ${contenido}`);
        console.log(`Nutriologo ID: ${localStorage.getItem('nutriologo_id')}`);

        // Paso 2: Verifica cómo se envían los datos
        const datos = {
            titulo: titulo,
            contenido: contenido,
            nutriologo_id: localStorage.getItem('nutriologo_id')
        };

        console.log(`Datos a enviar: ${JSON.stringify(datos)}`);

        axios.post('/api/v1/nutriologo/articulos', JSON.stringify(datos), {
            headers: {
                Authorization: `Bearer ${localStorage.getItem('token')}`,
                'Content-Type': 'application/json'
            }
        })
            .then(response => {
                console.log(response.data);
                document.getElementById('titulo').value = '';
                document.getElementById('contenido').value = '';
            })
            .catch(error => {
                // Paso 3: Manejo de errores en el servidor
                console.log('Error al guardar el articulo', error.response.data);
            });
    };

    return (
        <div className="container">
            <h1>Agregar Articulo</h1>
            <div className="row my-2">
                <div className="col-sm-6 my-1">
                    <label htmlFor="titulo">Agrega titulo al articulo</label>
                    <input type="text" className="form-control" id="titulo" />
                </div>
            </div>
            <div className="row my-2">
                <div className="col-sm-12 my-1">
                    <label htmlFor="contenido">Agrega el contenido del articulo</label>
                    <textarea className="form-control" id="contenido" rows="12"></textarea>
                </div>
            </div>
            <div className="row  flex-row-reverse">
                <div className="col-sm-12 my-1">
                    <button className="btn btn-primary mx-2" onClick={handleAgregarArticulo}>Agregar Articulo</button>
                    <button className="btn btn-secondary">Cancelar</button>
                </div>
            </div>
        </div>
    );
};

export default AgregarArticulo;
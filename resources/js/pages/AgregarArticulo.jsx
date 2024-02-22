import React, { useState } from "react";
import axios from "axios";
import ReactQuill from "react-quill";
import "react-quill/dist/quill.snow.css";

const AgregarArticulo = () => {
    const [titulo, setTitulo] = useState("");
    const [contenido, setContenido] = useState("");
    const [error, setError] = useState("");
    const [fileName, setFileName] = useState("");

    const handleFileChange = (event) => {
        const file = event.target.files[0];
        if (file) {
            setFileName(file.name);
        }
    };

    const handleAgregarArticulo = async () => {
        try {
            const response = await axios.post('/api/v1/nutriologo/articulos', {
                titulo: titulo,
                contenido: contenido,
                nutriologo_id: localStorage.getItem('nutriologo_id')
            }, {
                headers: {
                    Authorization: `Bearer ${localStorage.getItem('token')}`,
                    'Content-Type': 'application/json'
                }
            });

            console.log(response.data);
            setTitulo("");
            setContenido("");
        } catch (error) {
            console.log('Error al guardar el artículo', error.response.data);
            setError("Error al guardar el artículo. Por favor, inténtalo de nuevo.");
        }
    };

    return (
        <div className="container">
            <h1>Agregar Artículo</h1>
            <div className="row my-2">
                <div className="col-sm-6 my-1">
                    <label htmlFor="titulo">Título del Artículo</label>
                    <ReactQuill
                        value={titulo}
                        onChange={(value) => setTitulo(value)}
                        theme="snow"
                    />
                </div>
                <div className="col-sm-6 my-1">
                    <div className="card">
                        <div className="card-body">
                            <label htmlFor="cover-photo" className="form-label">Subir imagen</label>
                            <div className="mt-2">
                                <div className="d-flex justify-content-center align-items-center">
                                    <svg className="mb-3" viewBox="0 0 24 24" fill="currentColor" aria-hidden="true">
                                        <path fillRule="evenodd" d="M1.5 6a2.25 2.25 0 012.25-2.25h16.5A2.25 2.25 0 0122.5 6v12a2.25 2.25 0 01-2.25 2.25H3.75A2.25 2.25 0 011.5 18V6zM3 16.06V18c0 .414.336.75.75.75h16.5A.75.75 0 0021 18v-1.94l-2.69-2.689a1.5 1.5 0 00-2.12 0l-.88.879.97.97a.75.75 0 11-1.06 1.06l-5.16-5.159a1.5 1.5 0 00-2.12 0L3 16.061zm10.125-7.81a1.125 1.125 0 112.25 0 1.125 1.125 0 01-2.25 0z" clipRule="evenodd" />
                                    </svg>
                                    <div className="mb-3">
                                        <label htmlFor="file-upload" className="form-label d-block">
                                            <span>Subir archivo</span>
                                            <input id="file-upload" name="file-upload" type="file" className="form-control-file" />
                                        </label>
                                        <p className="text-center">o arrastrar y soltar</p>
                                    </div>
                                    <p className="text-muted text-center">PNG, JPG, GIF hasta 10MB</p>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div className="row my-2">
                <div className="col-sm-12 my-1">
                    <label htmlFor="contenido">Contenido del Artículo</label>
                    <ReactQuill
                        theme="snow"
                        value={contenido}
                        onChange={setContenido}
                    />
                </div>
            </div>
            <div className="row  flex-row-reverse">
                <div className="col-sm-12 my-1">
                    <button
                        className="btn btn-primary mx-2"
                        onClick={handleAgregarArticulo}
                        disabled={!titulo || !contenido}
                    >
                        Agregar Artículo
                    </button>
                    <button className="btn btn-secondary">Cancelar</button>
                </div>
            </div>
            {error && <div className="alert alert-danger mt-3" role="alert">{error}</div>}
        </div>
    );
};

export default AgregarArticulo;
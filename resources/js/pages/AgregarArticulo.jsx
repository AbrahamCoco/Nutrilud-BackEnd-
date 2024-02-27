import React, { useState } from "react";
import axios from "axios";
import ReactQuill from "react-quill";
import "react-quill/dist/quill.snow.css";
import { FaImage } from "react-icons/fa";

const AgregarArticulo = () => {
    const [titulo, setTitulo] = useState("");
    const [contenido, setContenido] = useState("");
    const [error, setError] = useState("");
    const [fileName, setFileName] = useState("");
    const [dragging, setDragging] = useState(false);
    const [imagePrevisualizada, setImagePrevisualizada] = useState(null);



    const handleDragEnter = (e) => {
        e.preventDefault();
        setDragging(true);
    };

    const handleDragLeave = () => {
        setDragging(false);
    };

    const handleDrop = (e) => {
        e.preventDefault();
        setDragging(false);
        // Manejar el archivo que se soltó aquí
        const file = e.dataTransfer.files[0];
        handleFileChange(file);
    };

    const handleFileChange = (event) => {
        const file = event.target.files[0];
        if (file) {
            setFileName(file.name);
            const reader = new FileReader();
            reader.onload = () => {
                setImagenPrevisualizada(reader.result);
            };
            reader.readAsDataURL(file);
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
                    <label htmlFor="">Subir imagen</label>
                    <div
                        className={`container bg-cardimage rounded ${dragging ? "drag-over" : ""}`}
                        onDragOver={(e) => e.preventDefault()}
                        onDragEnter={handleDragEnter}
                        onDragLeave={handleDragLeave}
                        onDrop={handleDrop}
                    >
                        <div className="row">
                            <div className="col-sm-4">
                                {imagePrevisualizada ? (
                                    <img src={imagePrevisualizada} alt="Previsualizacion de la imagen" style={{ width: "100px", height: "100px" }} />
                                ) : (
                                    <FaImage size={100} />
                                )}
                            </div>
                            <div className="col-sm-8 pt-4 text-center">
                                <label htmlFor="file-update" className="file-upload-label text-center">Elegir archivo</label>
                                <input
                                    type="file"
                                    className="sr-only"
                                    id="file-update"
                                    name="file-update"
                                    onChange={handleFileChange}
                                />
                                <label htmlFor="file-update" className="px-2">O</label>
                                <label htmlFor="file-update" className="text-center">Arrastra aquí el archivo</label>
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
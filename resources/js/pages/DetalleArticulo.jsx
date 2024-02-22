import React, { useEffect, useState } from "react";
import ReactQuill from "react-quill";
import "react-quill/dist/quill.bubble.css";
import { useParams } from "react-router-dom";

const DetalleArticulo = () => {
    const { id } = useParams();
    const [articulo, setArticulo] = useState(null);

    useEffect(() => {
        loadArticulo();
    }, [id]);

    const loadArticulo = async () => {
        try {
            const response = await axios.get(`/api/v1/articulo/${id}`);
            setArticulo(response.data.articulo);
        } catch (error) {
            console.log(error);
        }
    };

    if (!articulo) {
        return (
            <div className="container">
                <h1>Cargando artículo...</h1>
            </div>
        );
    }

    return (
        <div className='container'>
            <div className="row">
                <div className="col-sm-8 texto-justificado">
                    <ReactQuill
                        value={articulo.titulo}
                        readOnly={true}
                        theme="bubble"
                        className="title-article"
                    />
                    <ReactQuill
                        value={articulo.contenido}
                        readOnly={true}
                        theme="bubble"
                        className="container-article"
                    />
                    <p>Nutriólogo: <strong>{articulo.nutriologo.user.nombre} {articulo.nutriologo.user.primer_apellido} {articulo.nutriologo.user.segundo_apellido}</strong></p>
                    <p>Fecha de publicación: {new Date(articulo.created_at.split(' ')[0]).toLocaleDateString('es-ES', { year: 'numeric', month: 'long', day: 'numeric' })}</p>
                </div>
            </div>
        </div>
    );
}

export default DetalleArticulo;
import axios from 'axios';
import React, { useEffect, useState } from 'react';
import { format } from 'date-fns';
import { Link } from 'react-router-dom';

const Home = () => {
    const [articulos, setArticulos] = useState([]);

    useEffect(() => {
        loadArticulos();
    }, []);

    const loadArticulos = async () => {
        try {
            const response = await axios.get('/api/v1/');
            setArticulos(response.data.articulos);
        } catch (error) {
            console.log(error);
        }
    }

    const formatDate = (dateString) => {
        const date = new Date(dateString);
        return format(date, "dd 'de' MMMM 'de' yyyy");
    };

    return (
        <div className='container'>
            <h1>Articulos</h1>
            <div className="row">
                <div className="col-sm-8 texto-justificado">
                    <ul>
                        {articulos.map((articulo) => (
                            <li key={articulo.id}>
                                <h3><Link to={`/articulo/${articulo.id}`}>{articulo.titulo}</Link></h3>
                            </li>
                        ))}
                    </ul>
                </div>
            </div>
        </div>
    );
}

export default Home;
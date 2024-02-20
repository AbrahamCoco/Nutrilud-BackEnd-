import React, { useEffect, useState } from "react";
import { Container } from "react-bootstrap";
import "react-big-calendar/lib/css/react-big-calendar.css";
import FullCalendar from "@fullcalendar/react";
import dayGridPlugin from "@fullcalendar/daygrid";
import timeGridPlugin from "@fullcalendar/timegrid";
import listPlugin from "@fullcalendar/list";
import esLocale from "@fullcalendar/core/locales/es";
import axios from "axios";

const Calendar = (props) => {
    const [agenda, setAgenda] = useState(null);

    useEffect(() => {
        loadAgenda();
    }, []);

    const loadAgenda = async () => {
        try {
            const response = await axios.get("/api/v1/nutriologo/agenda");
            const eventos = response.data.agenda.map(evento => {
                const fechaInicio = new Date(evento.siguiente_consulta);
                const fechaFin = new Date(fechaInicio);
                fechaFin.setMinutes(fechaFin.getMinutes() + 30);

                return {
                    title: `Cita con el paciente: ${evento.consulta.user.nombre} ${evento.consulta.user.primer_apellido} ${evento.consulta.user.segundo_apellido}`,
                    start: fechaInicio,
                    end: fechaFin,
                };
            });
            setAgenda(eventos);
            console.log(eventos);
        } catch (error) {
            console.log(error);
        }
    };

    return (
        <Container>
            <h1>Calendario</h1>
            <div style={{ height: "300px" }}>
                <FullCalendar
                    locale={esLocale}
                    plugins={[dayGridPlugin, timeGridPlugin, listPlugin]}
                    headerToolbar={{
                        left: "prev,next today",
                        center: "title",
                        right: "dayGridMonth,timeGridWeek,timeGridDay,listWeek",
                    }}
                    initialView="dayGridMonth"
                    events={agenda}
                    slotMinTime={"08:00:00"}
                    slotMaxTime={"18:00:00"}
                    themeSystem="bootstrap4"
                />
            </div>
        </Container>
    );
};

export default Calendar;
import React, { useState } from "react";
import { Col, Container, Row } from "react-bootstrap";
import "react-big-calendar/lib/css/react-big-calendar.css";
import FullCalendar from "@fullcalendar/react";
import dayGridPlugin from "@fullcalendar/daygrid";
import timeGridPlugin from "@fullcalendar/timegrid";
import listPlugin from "@fullcalendar/list";
import esLocale from "@fullcalendar/core/locales/es";

const Calendar = (props) => {
    const events = [
        {
            title: "Cita con el paciente 1",
            start: new Date(2023, 11, 1, 10, 0, 0),
            end: new Date(2023, 11, 1, 10, 30, 0),
        },
        {
            title: "Cita con el paciente 2",
            start: new Date(2023, 11, 1, 10, 30, 0),
            end: new Date(2023, 11, 1, 11, 0, 0),
        },
    ];

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
                    events={events}
                    slotMinTime={"08:00:00"}
                    slotMaxTime={"18:00:00"}
                    themeSystem="bootstrap4"
                />
            </div>
        </Container>
    );
};

export default Calendar;
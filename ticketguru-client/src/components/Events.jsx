import React, { useState, useEffect } from 'react';
import { SERVER_URL } from '../constants/Constants';
import { AgGridReact } from 'ag-grid-react';
import "ag-grid-community/styles/ag-grid.css";
import "ag-grid-community/styles/ag-theme-quartz.css";
import SellTickets from './SellTickets';
import PrintTickets from './PrintTickets';
import { useNavigate } from "react-router-dom";

const Events = () => {
    const [events, setEvents] = useState([]);
    const [isLoading, setIsLoading] = useState(true);
    const [error, setError] = useState(null);
    const [modalIsOpen, setModalIsOpen] = useState(false);
    const [sendData, setSendData] = useState(null);
    const [printIsOpen, setPrintIsOpen] = useState(false);
    const [tickets, setTickets] = useState(null);
    const navigate = useNavigate();

    useEffect(() => {
        const credentials = sessionStorage.getItem('credentials');
        if (credentials === null) {
            navigate("/login", { replace: true });
        }
    }, [navigate]);

    const MyyLippujaButton = (params) => {
        // Funktio, joka käsittelee painikkeen klikkausta
        const handleClick = () => {
            const data = {
                tapahtumaId: params.data.tapahtumaId,
                tapahtumaNimi: params.data.tapahtumaNimi,
                aika: params.data.alkaaPvm,
                paikka: params.data.tapahtumapaikka.tapahtumapaikkaNimi,
                lipputyypit: params.data.lipputyypit
            }
            console.log(sendData);
            setSendData(data);
            setModalIsOpen(true);

            // tämä funktio siirtää sendData muuttujan tiedot toiselle komponentille, joka avautuu buttonia painettaessa
        };

        return <button className="btn btn-success" onClick={handleClick}>Myy lippuja</button>;
    };

    const closeModal = () => {
        setModalIsOpen(false);
        setSendData(null);
    };

    const closePrint = () => {
        setPrintIsOpen(false);
        setTickets(null);
        fetchEvents();
    };

    const handleServerResponse = (data) => {
        setTickets(data);
        setModalIsOpen(false);
        setPrintIsOpen(true);
    };

    const colDefs = [
        { field: "tapahtumaNimi", headerName: "Tapahtuma", flex: 1 },
        {
            field: "alkaaPvm", headerName: "Aika", flex: 1,
            valueFormatter: params => {
                if (!params.value) return '';
                // Oletetaan, että params.value on standardi ISO-muodossa (esim. "2024-02-11T19:00:00")
                const date = new Date(params.value);
                const options = { day: '2-digit', month: '2-digit', year: 'numeric', hour: '2-digit', minute: '2-digit', hour12: false };
                return new Intl.DateTimeFormat('fi-FI', options).format(date).replace(',', ' klo');
            }
        },
        { field: "tapahtumapaikka.tapahtumapaikkaNimi", headerName: "Tapahtumapaikka", flex: 1 },
        { field: "tapahtumapaikka.tapahtumapaikkaKaupunki", headerName: "Kaupunki", flex: 1 },
        { field: "lippujaJaljella", headerName: "Lippuja Jäljellä", flex: 1 },
        { field: "perushinta", headerName: "Perushinta", flex: 1 },
        {
            field: "lipputyypit", headerName: "Lipputyypit", minWidth: 400, flex: 1,
            valueFormatter: params => {
                if (!params.value) {
                    return "No data";
                }
                // Käyttäjä kerrotaan perushinta jokaisen lipputyypin hintakertoimella
                return params.value.map(lipputyypit => {
                    const laskettuHinta = params.data.perushinta * lipputyypit.hintakerroin;
                    return `${lipputyypit.asiakasryhma}: ${laskettuHinta.toFixed(2)} €`;
                }).join(", ");
            }
        },
        { field: "Myy lippuja", cellRenderer: MyyLippujaButton, flex: 1 }
    ];


    const fetchEvents = async () => {
        const credentials = sessionStorage.getItem('credentials');
        try {
            const response = await fetch(`${SERVER_URL}/tapahtumat`, {
                method: 'GET',
                headers: {
                    'Content-Type': 'application/json',
                    'Authorization': `Basic ${credentials}`
                }
            });
            if (!response.ok) {
                throw new Error('Network response was not ok');
            }
            const data = await response.json();
            setEvents(data);
            console.log(data);
            setIsLoading(false);
        } catch (error) {
            setError(error.message);
            setIsLoading(false);
        }
    };

    useEffect(() => {
        fetchEvents();
    }, []);

    return (
        <div className="ag-theme-quartz" style={{ height: 'auto', width: '100%' }}>
            <h1>Tapahtumat</h1>
            {isLoading ? (
                <p>Loading...</p>
            ) : error ? (
                <p>Error: {error}</p>
            ) : (
                <div>
                    <AgGridReact
                        rowData={events}
                        columnDefs={colDefs}
                        // frameworkComponents={frameworkComponents}
                        className="ag-theme-quartz"
                        domLayout='autoHeight'
                    />
                    <SellTickets
                        isOpen={modalIsOpen}
                        onRequestClose={closeModal}
                        eventData={sendData}
                        onServerResponse={handleServerResponse}
                    />
                    <PrintTickets
                        isOpen={printIsOpen}
                        onRequestClose={closePrint}
                        ticketData={tickets}
                    />
                </div>
            )}
        </div>
    );
}

export default Events;

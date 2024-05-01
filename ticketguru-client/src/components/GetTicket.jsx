import { Button, TextField, Stack, Paper, List, ListItem, Typography } from "@mui/material";
import { useEffect, useState } from "react";
import { SERVER_URL } from '../constants/Constants';
import { useNavigate } from "react-router-dom";

const GetTicket = () => {

    const [ticket, setTicket] = useState({});
    const [ticketUUID, setTicketUUID] = useState("");
    const [err, setErr] = useState('');
    const [data, setData] = useState('');
    const navigate = useNavigate();

    useEffect(() => {
        const credentials = sessionStorage.getItem('credentials');
        if (credentials === null) {
            navigate("/login", { replace: true });
        }
    }, [navigate]);

    const requestOptions = {
        method: 'GET',
        cache: 'no-cache',
        credentials: 'include',
        headers: {
            'Content-Type': 'application/json',
            'Authorization': `Basic ${sessionStorage.getItem('credentials')}`
        }
    };

    const handleChangeTicketUUID = (event) => {
        setTicketUUID(event.target.value);
    };

    const fetchTicket = async () => {
        try {
            const response = await fetch(`${SERVER_URL}/liput?tarkistuskoodi=${ticketUUID}`, requestOptions)
            console.log(requestOptions)
            const json = await response.json();
            setTicket(json)
        } catch (error) {
            setErr('Error fetching ticket: ', error.message)
        }
    };

    useEffect(() => {
        showTicket();
    }, [ticket])

    const showTicket = () => {
        if (ticket == null) {
            setData(<p>Haku epäonnistui: {err}</p>)
        } else {
            setData(
                <List>
                    <ListItem>
                        <Typography variant="body1">Tapahtuma: {ticket.tapahtumanNimi}</Typography>
                    </ListItem>
                    <ListItem>
                        <Typography variant="body1">Tapahtumapaikka: {ticket.tapahtumaPaikka}</Typography>
                    </ListItem>
                    <ListItem>
                        <Typography variant="body1">Lipputyyppi: {ticket.lipputyyppi}</Typography>
                    </ListItem>
                </List>
            )
        }
    };

    return (
        <Paper elevation={24} style={{ padding: '20px', maxWidth: '500px' }}>
            <Stack container spacing={2}>
                <TextField label="Lipun tarkistuskoodi" variant="standard" onChange={handleChangeTicketUUID} name="ticketUUID" />
                <Button variant="contained" onClick={fetchTicket}>Hae lippu</Button>
                {data}
            </Stack>
        </Paper>
    )
};

export default GetTicket
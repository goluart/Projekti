import { Button, TextField, Stack, Paper, List, ListItem, Typography } from "@mui/material";
import { useEffect, useState } from "react";

const GetTicket = () => {

    const [password, setPassword] = useState('');
    const [username, setUsername] = useState('');
    const [ticket, setTicket] = useState({});
    const [ticketUUID, setTicketUUID] = useState("");
    const [err, setErr] = useState('');
    const [data, setData] = useState('');

    const requestOptions = {
        method: 'GET',
        cache: 'no-cache',
        credentials: 'include',
        headers: {
            'Content-Type': 'application/json',
            'Authorization': `Basic ${btoa(username + ':' + password)}`
        }
    };

    const handleChangeUsername = (event) => {
        setUsername(event.target.value);
    };

    const handleChangePassword = (event) => {
        setPassword(event.target.value);
    };

    const handleChangeTicketUUID = (event) => {
        setTicketUUID(event.target.value);
    };

    const fetchTicket = async () => {
        try {
            const response = await fetch(`https://projekti-ticketguru-tiimi4.rahtiapp.fi/liput?tarkistuskoodi=${ticketUUID}`, requestOptions)
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
                <TextField label="Käyttäjä" variant="standard" onChange={handleChangeUsername} name="username" />
                <TextField label="Salasana" variant="standard" onChange={handleChangePassword} name="password" />
                <TextField label="Lipun tarkistuskoodi" variant="standard" onChange={handleChangeTicketUUID} name="ticketUUID" />
                <Button variant="contained" onClick={fetchTicket}>Hae lippu</Button>
                {data}
            </Stack>
        </Paper>
    )
};

export default GetTicket
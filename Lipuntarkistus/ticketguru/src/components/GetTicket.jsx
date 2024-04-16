import { useState } from "react";
import { Link, useParams } from "react-router-dom";

const GetTicket = () => {

    let { accessToken } = useParams();
    const [ticket, setTicket] = useState({});
    const [ticketUUID, setTicketUUID] = useState("");
    const [err, setErr] = useState('');
    const [data, setData] = useState('');
    const [used, setUsed] = useState('');

    const requestOptions = {
        method: 'GET',
        headers: {
            'Content-Type': 'application/json',
            'Authorization': `Bearer ${accessToken}`
        }
    };

    const handleChangeTicketUUID = (event) => {
        setTicketUUID(event.target.value);
    };

    const fetchTicket = async () => {
        try {
            const response = await fetch(`https://copypaste-ohjelmistoprojekti-copypaste-ticketguru.rahtiapp.fi/api/tickets/byUuid?uuid=${ticketUUID}`, requestOptions)
            const json = await response.json();
            setTicket(json)
        } catch (error) {
            setErr('Error fetching ticket: ', error.message)
        }
        showTicket();
    };

    const showTicket = () => {
        if (ticket.used == true) {
            setUsed('yes');
        } if (ticket.used == false) {
            setUsed('no')
        }
        if (ticket == null) {
            setData(<p>Fetch failed: {err}</p>)
        } else {
            setData( // tieto tulee json muodossa, mutta lipputyypin nimeä ei pysty lukemaan
                <div>
                    <p>Ticket type: {ticket.ticketType.name}</p>
                    <p>Ticket event id: {ticket.event}</p>
                    <p>Ticket used: {used}</p>
                </div>
            )
        }
    };

    return (
        <div>
            <form>
                <label>Fetch ticket info
                    <input type='text' onChange={handleChangeTicketUUID} name='ticketUUID' placeholder="Write the code" /><br />
                </label>
                <input type='button' onClick={fetchTicket} value='Search' />
            </form>
            {data}
            <Link to={'/check/' + accessToken}>Check ticket</Link>
        </div>)
};

export default GetTicket
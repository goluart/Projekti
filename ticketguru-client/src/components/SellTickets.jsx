import React, { useState } from 'react';
import Modal from 'react-modal';
import { SERVER_URL } from '../constants/Constants';

Modal.setAppElement('#root');

function SellTickets({ isOpen, onRequestClose, eventData, onServerResponse }) {

    const [ticketCounts, setTicketCounts] = useState(() => {
        const counts = {}
        eventData?.lipputyypit.forEach(lipputyyppi => {
            counts[lipputyyppi.lipputyyppiId] = 0;
        });
        return counts;
    });

    const handleInputChange = (lipputyyppiId, value) => {
        setTicketCounts(param => ({ ...param, [lipputyyppiId]: value }));
      };

    const handleClose = () => {
        // Nollataan lomake ja suljetaan
        setTicketCounts({});
        onRequestClose();
    };

    const handleSubmit = async (event) => {
        event.preventDefault();
        const dataToSend = {
            tapahtumaId: eventData.tapahtumaId,
            lippuTyyppiMaarat: eventData.lipputyypit.map(lipputyyppi => ({
                lipputyyppiId: lipputyyppi.lipputyyppiId,
                lippuMaara: ticketCounts[lipputyyppi.lipputyyppiId]
            }))
            .filter(lipputyyppi => lipputyyppi.lippuMaara > 0)
        };

        const response = await fetch(`${SERVER_URL}/myyntitapahtumat`, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
                'Authorization': `Basic ${sessionStorage.getItem('credentials')}`
            },
            body: JSON.stringify(dataToSend)
        });
        const responseData = await response.json();
        onServerResponse(responseData);
        console.log(JSON.stringify(dataToSend))
        console.log(responseData);
        setTicketCounts({});
    }

    if (!isOpen) {
        return null;
    }

    return (
        <Modal
        isOpen={isOpen}
        onRequestClose={onRequestClose}
        contentLabel="Event Details"
        style={{
            content: {
            top: '50%',
            left: '50%',
            right: 'auto',
            bottom: 'auto',
            marginRight: '-50%',
            transform: 'translate(-50%, -50%)',
            },
        }}
        >
        <h2>{eventData.tapahtumaNimi}</h2>
        <p>Aika: {eventData.aika}</p>
        <p>Paikka: {eventData.paikka}</p>

        <form onSubmit={handleSubmit}>
        {eventData?.lipputyypit.map(lipputyyppi => (
          <div key={lipputyyppi.lipputyyppiId}>
            <label className='form-control'>
              {lipputyyppi.asiakasryhma}
              <input
                type="number"
                value={ticketCounts[lipputyyppi.lipputyyppiId]}
                onChange={(e) => handleInputChange(lipputyyppi.lipputyyppiId, parseInt(e.target.value))}
                min="0"
                className='form-control'
              />
              <br/>
            </label>
          </div>
        ))}
        <div>
          <button className='btn btn-success' type="submit">Lähetä</button>
          <button className='btn btn-primary' onClick={() => handleClose()}>Sulje</button>
        </div>

      </form>
        </Modal>
    )
    }

export default SellTickets;

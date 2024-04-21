import React from 'react'
import Modal from 'react-modal';

Modal.setAppElement('#root');

function PrintticketData({isOpen, onRequestClose, ticketData}) {

    if (!isOpen) {
        return null;
    }
    
    return (
        <Modal
            isOpen={isOpen}
            onRequestClose={onRequestClose}
            contentLabel="Ticket Details"
            style={{
                overlay: {
                    backgroundColor: 'rgba(0, 0, 0, 0.75)'  // Lisää peittävyys taustalle, jos haluat
                },
                content: {
                    position: 'absolute',
                    top: '10%',  // Aseta ylämarginaali
                    left: '50%',
                    right: 'auto',
                    bottom: 'auto',
                    marginRight: '-50%',
                    transform: 'translate(-50%, 0)',  // Vain horisontaalinen keskitys
                    width: '80%',  // Leveys prosentteina
                    maxHeight: '80vh',  // Maksimikorkeus prosentteina näytön korkeudesta
                    overflowY: 'auto',  // Varmistaa, että sisältö on vieritettävä pystysuunnassa
                    padding: '20px',  // Sisäinen padding
                    border: '1px solid #ccc',  // Kehys
                    borderRadius: '10px',  // Pyöristetyt kulmat
                    background: '#fff'  // Taustaväri
                }
            }}
            >
                {/* <p>Server Response: {JSON.stringify(ticketData)}</p> */}
                <div className='card'>
                    <div className='card-body'>
                        <h1>TicketGuru</h1>
                        <p>Myyntitapahtuma: {ticketData.myyntitapahtumaId}</p>
                        <p>Päivämäärä: {ticketData.myyntitapahtumaPvm}</p>
                        <p>Loppusumma: {ticketData.loppusumma}</p>
                        <h4 className='card-title'>Liput</h4>
                        <ul class="list-group list-group-flush">
                        {ticketData.liputDto.map((lippu, index) => (
                                <li key={index} className="list-group-item">
                                    <h4 class>{lippu.tapahtumanNimi}</h4>
                                    <p>{lippu.tapahtumaAika}</p>
                                    <p>{lippu.tapahtumaPaikka}</p>
                                    <p>{lippu.lipputyyppi} {lippu.hinta} €</p>
                                    <p>{lippu.tarkistuskoodi}</p>
                                </li>                    
                ))}
                </ul>
            <button onClick={onRequestClose}>Sulje Tapahtuma</button>
                    </div>
                </div>
        </Modal>
    )
}

export default PrintticketData;

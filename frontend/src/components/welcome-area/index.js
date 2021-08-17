
import React, { useState } from 'react';
import AnchorLink from 'react-anchor-link-smooth-scroll'
import { Button, Modal, ModalHeader, ModalBody, ModalFooter } from 'reactstrap';
import './style.css'

const Welcome = (props) => {
  const {
    className
  } = props;

  const [modal, setModal] = useState(false);

  const toggle = () => setModal(!modal);

  return (

    <div  className={`welcome-area ${props.welcome}`}>
        <div className="container">
            <div className="row">
                <div className="col-lg-12">
                    <div className="welcome-content">
                        <h2>O grande dia</h2>
                        <p>Estamos preparando tudo com muito carinho para compartilharmos  com nossos familiares e amigos esse momento tão especial em nossas vidas! Esperamos vocês com muita alegria para testemunharem nosso amor e para fazermos um brinde a essa nova etapa que se inicia. Saibam que se chegaram até aqui, é porque são importantes para nós e gostaríamos muito que estivessem conosco. Aguardamos vocês!</p>
                        <div className="btn"><AnchorLink href='#rsvp'>Confirmação</AnchorLink></div>
                        <Button className="btn" onClick={toggle}>Localização</Button>
                        <Modal isOpen={modal} toggle={toggle} className={className}>
                            <ModalHeader toggle={toggle}>Localização</ModalHeader>
                            <ModalBody>
                                <div className="location-map">
                                <iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3752.863000025897!2d-43.99839868509371!3d-19.84574888665102!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0xa6916989a36ab7%3A0xa3f45c4f2f10aada!2sIlustre%20Garden%20Recep%C3%A7%C3%B5es!5e0!3m2!1sen!2sbr!4v1627950452069!5m2!1sen!2sbr" ></iframe>
                                </div>
                            </ModalBody>
                        </Modal>
                    </div>
                </div>
            </div>
        </div>
    </div>

  );
}

export default Welcome;
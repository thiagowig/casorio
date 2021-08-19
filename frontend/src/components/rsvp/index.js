import React, { Component } from 'react';
import Sectiontitle from '../section-title'
import './style.css'

class Rsvp extends Component {

    state = {
        name: '',
        email: '',
        rsvp: '',
        events: '',
        notes: '',
        error: {}
    }


    changeHandler = (e) => {
        const error = this.state.error;
        error[e.target.name] = ''

        this.setState({
            [e.target.name]: e.target.value,
            error
        })
    }

    subimtHandler = (e) => {
        e.preventDefault();

        const { name,
            email,
            rsvp,
            events,
            notes, error } = this.state;

        if (name === '') {
            error.name = "Informe o seu nome";
        }
        if (email === '') {
            error.email = "Informe o seu email";
        }
        if (rsvp === '') {
            error.rsvp = "Select your number of rsvp";
        }
        if (events === '') {
            error.events = "Select your event list";
        }


        if (error) {
            this.setState({
                error
            })
        }
        if (error.name === '' && error.email === '' && error.email === '' && error.rsvp === '' && error.events === '' && error.notes === '') {
            this.setState({
                name: '',
                email: '',
                rsvp: '',
                events: '',
                notes: '',
                error: {}
            })
        }

        console.log(this.state);
        console.log(this.state.error.notes);
    }

    render() {

        const { name,
            email,
            rsvp,
            events,
            notes, error } = this.state;
        return (
            <div id="rsvp" className="rsvp-area go-rsvp-area section-padding rsvp-section">
                <Sectiontitle section={'Confirme sua presença'} />
                <div className="container">
                    <div className="row">
                        <div className="col-lg-8 offset-lg-2 col-md-10 offset-md-1">
                            <div className="gta-content">
                                <p>A confirmação de presença é muito importante para podermos organizar o nosso grande dia da melhor maneira possível. Sabemos que a pandemia ainda não acabou e caso você não se sinta confortável para reunir com um maior número de pessoas, iremos entender. A entrada no local será feita através de uma "lista de presença", sendo imprescindível a confirmação com o nome completo do convidado.</p>
                            </div>
                            <div className="rsvp-wrap">
                                <form onSubmit={this.subimtHandler}>
                                    <div className="contact-form form-style">
                                        <div className="col-12 col-sm-12">
                                            <input type="text" value={name} onChange={this.changeHandler} placeholder="Seu nome*" id="fname" name="name" />
                                            <p>{error.name ? error.name : ''}</p>
                                        </div>
                                        <div className="col-12  col-sm-12">
                                            <input type="text" placeholder="Seu email*" onChange={this.changeHandler} value={email} id="email" name="email" />
                                            <p>{error.email ? error.email : ''}</p>
                                        </div>
                                        <div className="col-12 col-sm-12">
                                            <textarea className="contact-textarea" value={notes} onChange={this.changeHandler} placeholder="Mensagem" name="notes"></textarea>
                                            <p>{error.notes ? error.notes : ''}</p>
                                        </div>
                                        <div className="col-12 text-center">
                                            <button id="submit" type="submit" className="submit">Confirmar</button>
                                        </div>
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}

export default Rsvp;
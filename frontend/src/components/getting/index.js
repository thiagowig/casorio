import React from 'react';
import Sectiontitle from '../section-title'
import { Button } from 'reactstrap';
import './style.css'



const Getting = () => {
    return (
        <div id="gift" className="gta-area section-padding">
            <Sectiontitle section={'Presentes'} />
            <div className="container">
                <div className="row">
                    <div className="col col-lg-8 offset-lg-2 col-md-8 offset-md-2">
                        <div className="row">
                            <div className="gta-content">
                                <p>Queridos familiares e amigos, como muitos sabem, já temos nosso apartamento mobiliado. Por isso, vamos disponibilizar nossa chave PIX caso alguém prefira converter o valor do presente em dinheiro para nos ajudar na lua de mel. Para os que preferem comprar o presente, fizemos uma lista no Quero de Casamento (Magazine Luiza).</p>   
                                <p><b>OBS: Não vamos ter corte de gravata durante a festa</b></p>
                            </div>
                            <div className="heading col-md-12 col-sm-6">
                                <br/>
                                <h1>Chave Pix</h1>
                                <div className="gta-content02">
                                    <p>thiagofonsecapix@gmail.com <Button style={{paddingLeft: 10, paddingRight: 10}} onClick={() => {navigator.clipboard.writeText('thiagofonsecapix@gmail.com')}}>Copiar</Button></p>
                                    
                                </div>
                            </div>
                            <div className="heading col-md-12 col-sm-6">
                                <h1>Lista Online</h1>
                                <div className="gta-content02">
                                <p><a href="https://finalfeliz.de/simone-thiago-2021" target="_blank">https://finalfeliz.de/simone-thiago-2021</a></p>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    )
}

export default Getting;
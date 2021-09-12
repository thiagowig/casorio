import React, { Component } from "react";
import Slider from "react-slick";
import Sectiontitle from '../section-title'
import "slick-carousel/slick/slick.css";
import "slick-carousel/slick/slick-theme.css";
import gift1 from '../../images/groomsmen-bridesmaid/valdirElizete.jpeg'
import gift2 from '../../images/groomsmen-bridesmaid/talentoEGeizy.jpeg'
import gift3 from '../../images/groomsmen-bridesmaid/catolBibi.jpeg'
import gift4 from '../../images/groomsmen-bridesmaid/pedroMaira.jpeg'
import gift5 from '../../images/groomsmen-bridesmaid/mauroFatima.jpeg'
import gift6 from '../../images/groomsmen-bridesmaid/vissalEAriana.jpeg'
import gift7 from '../../images/groomsmen-bridesmaid/grasiSerginho.jpeg'
import gift8 from '../../images/groomsmen-bridesmaid/lucaseRachel.jpeg'
import gift9 from '../../images/groomsmen-bridesmaid/barbara.jpeg'
import gift10 from '../../images/groomsmen-bridesmaid/saulo.jpg'
import gift11 from '../../images/groomsmen-bridesmaid/duEAdiana.jpeg'
import gift12 from '../../images/groomsmen-bridesmaid/larissaMatheus.jpeg'
import gift13 from '../../images/groomsmen-bridesmaid/lucasEJulia.jpg'
import gift14 from '../../images/groomsmen-bridesmaid/carolEThiago.jpg'

import './style.css'


class Gift extends Component {
  render() {
    var settings = {
      dots: false,
      arrows: false,
      speed: 1000,
      slidesToShow: 2,
      slidesToScroll: 1,
      autoplay: true,
      autoplaySpeed: 2000,
      responsive: [
        {
          breakpoint: 1024,
          settings: {
            slidesToShow: 1,
            slidesToScroll: 1,
            infinite: true,
          }
        },
        {
          breakpoint: 600,
          settings: {
            slidesToShow: 1,
            slidesToScroll: 1
          }
        },
        {
          breakpoint: 480,
          settings: {
            slidesToShow: 1,
            slidesToScroll: 1
          }
        }
      ]
    };
    return (
      <div id="people" className="gift-area section-padding">
        <Sectiontitle section={'Madrinhas e Padrinhos'} />
        <div className="container">
          <div className="row">
            <div className="col-lg-12">
              <Slider {...settings}>
                <div className="item">
                  <img src={gift1} alt="" style={{borderRadius: 10}}/>
                </div>
                <div className="item">
                  <img src={gift2} alt="" style={{borderRadius: 10}}/>
                </div>
                <div className="item">
                  <img src={gift3} alt="" style={{borderRadius: 10}}/>
                </div>
                <div className="item">
                  <img src={gift4} alt="" style={{borderRadius: 10}}/>
                </div>
                <div className="item">
                  <img src={gift5} alt="" style={{borderRadius: 10}}/>
                </div>
                <div className="item">
                  <img src={gift6} alt="" style={{borderRadius: 10}}/>
                </div>
                <div className="item">
                  <img src={gift7} alt="" style={{borderRadius: 10}}/>
                </div>
                <div className="item">
                  <img src={gift8} alt="" style={{borderRadius: 10}}/>
                </div>
                <div className="item">
                  <img src={gift9} alt="" style={{borderRadius: 10}}/>
                </div>
                <div className="item">
                  <img src={gift10} alt="" style={{borderRadius: 10}}/>
                </div>
                <div className="item">
                  <img src={gift11} alt="" style={{borderRadius: 10}}/>
                </div>
                <div className="item">
                  <img src={gift12} alt="" style={{borderRadius: 10}}/>
                </div>
                <div className="item">
                  <img src={gift13} alt="" style={{borderRadius: 10}}/>
                </div>
                <div className="item">
                  <img src={gift14} alt="" style={{borderRadius: 10}}/>
                </div>
              </Slider>
            </div>
          </div>
        </div>
      </div>
    );
  }
}

export default Gift;
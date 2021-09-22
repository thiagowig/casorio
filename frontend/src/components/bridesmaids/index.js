import React, {Component} from 'react';
import ReactFancyBox from 'react-fancybox'
import 'react-fancybox/lib/fancybox.css'
import Sectiontitle from '../section-title'
import './style.css'

import galimg1 from '../../images/bridesmaids/01.jpg'
import galimg2 from '../../images/bridesmaids/02.jpg'
import galimg3 from '../../images/bridesmaids/03.jpg'

class Bridesmaids extends Component {
  render() {
    return (
      <div id="bridesmaids" className="section-padding">
          <Sectiontitle section={'Daminhas'}/>
          <div className="container">
              <div className="row">
                  <div className="col-lg-4 col-md-6 col-sm-6 col-12">
                      <div className="bridesmaids-img">
                        <ReactFancyBox
                            thumbnail={galimg1}
                            image={galimg1}/>
                      </div>
                  </div>
                  <div className="col-lg-4 col-md-6 col-sm-6 col-12">
                      <div className="bridesmaids-img">
                        <ReactFancyBox
                            thumbnail={galimg2}
                            image={galimg2}/>
                      </div>
                  </div>
                  <div className="col-lg-4 col-md-6 col-sm-6 col-12">
                      <div className="bridesmaids-img">
                        <ReactFancyBox
                            thumbnail={galimg3}
                            image={galimg3}/>
                      </div>
                  </div>
              </div>
          </div>
      </div>
    );
  }
}

export default Bridesmaids;
import React from  'react';

// components
import Couple from '../../components/couple';
import SimpleSlider from '../../components/hero';
import Welcome from '../../components/welcome-area';
import People from '../../components/people';
import Location from '../../components/location';
import Gallery from '../../components/gallery';
import Rsvp from '../../components/rsvp';
import Getting from '../../components/getting';
import Navbar from '../../components/Navbar'
import Saveday from '../../components/countdown'
import Footer from '../../components/footer'

import couple1 from '../../images/couple/simone.jpg'
import couple2 from '../../images/couple/thiago.jpeg'


const Homepage = () => {
    return(
       <div>
           <Navbar/>
           <SimpleSlider/>
           <Saveday/>
           <Couple coupleimg1={couple1} coupleimg2={couple2}/>
           <Gallery/>
           <Welcome/>
           <People/>
           <Location/>
           <Getting/>
           <Footer />
       </div>
    )
}

export default Homepage;
import React from 'react'
import './homepage.css'
import { useNavigate } from 'react-router-dom'

const HomePage = () => {
  const navigate = useNavigate()
  return (
    <div className="home-container">
      <section className="hero">
        <h1>Transform Your Photos into Ghibli Art</h1>
        <p>Experience the magic of Studio Ghibli’s style with our AI art generator.</p>
        <button onClick={() => navigate('/create')}>Try Ghibli AI</button>
      </section>

      <section id="features" className="section">
        <h2>Features</h2>
        <p>High quality, fast generation, and anime-style AI images.</p>
      </section>

      <section id="gallery" className="section">
        <h2>Gallery</h2>
        <p>Ghibli art showcase will appear here soon!</p>
      </section>

      <section id="faq" className="section">
        <h2>FAQ</h2>
        <p><strong>Q:</strong> Is this free?<br /><strong>A:</strong> Yes, for now!</p>
      </section>
    </div>
  )
}

export default HomePage

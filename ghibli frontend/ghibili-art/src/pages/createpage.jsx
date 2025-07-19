import React, { useState } from 'react';
import { generateFromImage, generateFromText } from '../api/ghibliapi';
import './createpage.css';

const CreatePage = () => {
  const [tab, setTab] = useState('image');
  const [file, setFile] = useState(null);
  const [prompt, setPrompt] = useState('');
  const [style, setStyle] = useState('anime');
  const [resultImage, setResultImage] = useState(null);
  const [loading, setLoading] = useState(false);

  const handleGenerate = async () => {
    setLoading(true);
    try {
      let imageUrl;
      if (tab === 'image') {
        const img = new Image();
        img.onload = async () => {
          if (img.width < 320 || img.height < 320) {
            alert(`❌ Uploaded image is too small (${img.width}x${img.height}).\nMinimum required: 320x320 pixels.`);
            setLoading(false);
            return;
          }
          const imageUrl = await generateFromImage(file, prompt);
          setResultImage(imageUrl);
          setLoading(false);
        };
        img.onerror = () => {
          alert("❌ Could not read the uploaded image.");
          setLoading(false);
        };
        img.src = URL.createObjectURL(file);
        return; // Wait for image load to finish
      }
      
      
      setResultImage(imageUrl);
    } catch (err) {
      alert('Failed to generate image!');
    } finally {
      setLoading(false);
    }
  };

  return (
    <div className="create-container">
      <div className="tab-buttons">
        <button className={tab === 'image' ? 'active' : ''} onClick={() => setTab('image')}>
          Photo to Art
        </button>
        <button className={tab === 'text' ? 'active' : ''} onClick={() => setTab('text')}>
          Text to Art
        </button>
      </div>

      {tab === 'image' && (
        <div className="form">
          <input type="file" accept="image/*" onChange={(e) => setFile(e.target.files[0])} />
          <textarea
            placeholder="Enter your prompt..."
            value={prompt}
            onChange={(e) => setPrompt(e.target.value)}
          />
        </div>
      )}

      {tab === 'text' && (
        <div className="form">
          <textarea
            placeholder="Enter your prompt..."
            value={prompt}
            onChange={(e) => setPrompt(e.target.value)}
          />
          <select value={style} onChange={(e) => setStyle(e.target.value)}>
            <option value="anime">Anime</option>
            <option value="fantasy">Fantasy</option>
            <option value="enhance">Enhance</option>
          </select>
        </div>
      )}

      <button className="generate-btn" onClick={handleGenerate} disabled={loading}>
        {loading ? 'Generating...' : 'Generate Image'}
      </button>

      {resultImage && (
        <div className="result">
          <h3>Result:</h3>
          <img src={resultImage} alt="Generated Art" />
          <a href={resultImage} download="ghibli-art.png" className="download-btn">
            Download
          </a>
        </div>
      )}
    </div>
  );
};

export default CreatePage;

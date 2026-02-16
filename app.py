# -*- coding: utf-8 -*-
"""
Created on Tue Feb 10 18:46:30 2026

@author: Avery Booth
"""

from distutils.log import debug
from fileinput import filename
from flask import *  
import os

UPLOAD_FOLDER = 'C:/Users/Avery Booth/Downloads'

app = Flask(__name__)
app.config['UPLOAD_FOLDER'] = UPLOAD_FOLDER

@app.route('/')
def home():
    return "Hello World 12"

@app.route('/1')
def home1():
    return "Hello World 3"

@app.route('/upload', methods = ['POST'])  
def uploadVideo():  
    if request.method == 'POST':  
        if 'video' not in request.files:
            print("hello")
            return jsonify({"error": "No video file provided"}), 400

            video = request.files['video']
    
            if video.filename == '':
                return jsonify({"error": "Empty filename"}), 400
    
                
    print("at save")
    request.files['video'].save(os.path.join("C:/Users/Avery Booth/Downloads", request.files['video'].filename))    
    

    return jsonify({"message": "Upload successful"}), 200

if __name__ == '__main__':  
    app.run( )
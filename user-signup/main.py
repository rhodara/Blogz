from flask import Flask, request, redirect, render_template
import cgi
import os
app = Flask(__name__)
app.config['DEBUG'] = True
  
@app.route('/')
@app.route('/signup-form')
def index():
    return render_template('edit.html')
    return render_template('signup_form.html')
 
@app.route('/signup-form', methods=['POST'])
def validate_signup_form():
  
@app.route('/signup', methods=['POST'])
def signup():
    username = request.form['username']
    password = request.form['password']
    verify_password = request.form['verify_password']
    email = request.form['email']
    username_error = ''
    password_error = ''
    verify_password = ''
    verify_error = ''
    email_error = ''
  
    if not username:
        username_error = 'Please enter a username'
    elif len(username) < 3 or len(username) > 20:
        username_error = 'Username must be between 3 and 20 characters'
        username = ''
    elif ' ' in username:
        username_error = 'Username cannot contain spaces'
        username = ''

    if not password:
        password_error = 'Please enter a password'
    elif len(password) < 3 or len(password) > 20:
        password_error = 'Password must be between 3 and 20 characters'
        password = ''
    elif ' ' in password:
        password_error = 'Password cannot contain spaces'
        password = ''
    if password != verify_password:
        verify_error = 'The passwords do not match'
        verify_password = ''
 
    if not email:
        email = ''
    else:
        if ' ' in email:
            email_error = 'Email cannot contain spaces'
            email = ''
        elif email.count("@") != 1:
            email_error = 'Email must have one "@" symbol'
            email = ''
        elif email.count(".") != 1:
            email_error = 'Email must have one "."'
            email = ''
        elif len(email) < 3 or len(email) > 20:
            email_error = 'Email must be between 3 and 20 characters'
            email = ''
  
    if not username_error and not password_error and not verify_error and not email_error:
        return render_template('welcome.html', username=username)
    else:
        return render_template('signup_form.html', username_error=username_error,
            password_error=password_error, verify_error=verify_error, email_error=email_error,
            username=username,
            email=email)
  
 @app.route('/welcome', methods=['GET'])
 def welcome():
    return render_template('welcome.html', name=username)
  
app.run()


import React, { Component } from 'react';

class SignupPage extends Component {

  doSignup = () => {
    const username = this.refs.username.value;
    const pass1 = this.refs.pass1.value;
    const pass2 = this.refs.pass2.value;
    const firstname = this.refs.firstname.value;
    const lastname = this.refs.lastname.value;
    const gender = this.refs.gender.value;
    const email = this.refs.email.value;
    const phonenumber = this.refs.phonenumber.value;
    const birthday = this.refs.birthday.value;

    this.props.handleSignup(username, pass1, pass2, firstname, lastname, gender, email, phonenumber, birthday);
  }

  render() {
    return (
      <div id="signup-form">
        <h1 className="page-title">Signup Page</h1>
          <div className="row">
            <div className="columns small-centered small-10 medium-6 large-4">
              <div className="callout callout-auth">
          <label className="input-form">Username:
            <input id="signup-username" type="text" ref="username" placeholder="input username..."/>
          </label>
          <label className="input-form">Password:
            <input id="signup-password1" type="password" ref="pass1" placeholder="input password..."/>
          </label>
          <label className="input-form">Password Again:
            <input id="signup-password2" type="password" ref="pass2" placeholder="input password again..."/>
          </label>
          <label className="input-form">FirstName:
            <input id="signup-firstname" type="text" ref="firstname" placeholder="your firstname..."/>
          </label>
          <label className="input-form">LastName:
            <input id="signup-lastname" type="text" ref="lastname" placeholder="your lastname..."/>
          </label>
          <label className="input-form">Gender:
            <input id="signup-gender" type="text" ref="gender" placeholder="your gender..."/>
          </label>
          <label className="input-form">Email:
            <input id="signup-email" type="text" ref="email" placeholder="your email..."/>
          </label>
          <label className="input-form">PhoneNumber:
            <input id="signup-phonenumber" type="text" ref="phonenumber" placeholder="your phone number..."/>
          </label>
          <label className="input-form">Birthday:
            <input id="signup-birthday" type="text" ref="birthday" placeholder="your birthday..."/>
          </label>
          <button id="signup-confirm-button" className="success button expanded" onClick={this.doSignup}>Submit</button>
          <p className="error-message">{this.props.signupErrorMSG}</p>
        </div>
      </div>
    </div>
  </div>
    );
  }
}

export default SignupPage;

import React, { Component } from 'react';

import News from './News';

class NewsList extends Component {

  render() {
    const newsList = this.props.newsList.map((news, index)=> {
      return <News {...news} key={news.request_id} index={index+1}/>
    });

    const renderNewsList = () => {
        if(newsList.length === 0) {
          return <p>No search results!</p>
        } else {
          return <div>{newsList}</div>
        }
    };

    return (
      <div className="container">
        {renderNewsList()}
      </div>
    );
  }
}

export default NewsList;

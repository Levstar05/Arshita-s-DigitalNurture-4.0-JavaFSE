// src/Posts.js
import React, { Component } from 'react';
import Post from './Post'; // importing Post class

class Posts extends Component {
  constructor(props) {
    super(props);
    this.state = {
      posts: [],
    };
  }

  loadPosts = async () => {
    try {
      const response = await fetch('https://jsonplaceholder.typicode.com/posts');
      const data = await response.json();
      const postObjects = data.map(p => new Post(p.userId, p.id, p.title, p.body));
      this.setState({ posts: postObjects });
    } catch (error) {
      console.error('Fetch error:', error);
    }
  };

  componentDidMount() {
    this.loadPosts();
  }

  componentDidCatch(error, info) {
    alert('Something went wrong: ' + error);
  }

  render() {
    return (
      <div>
        <h2>Posts</h2>
        {this.state.posts.map(post => (
          <div key={post.id}>
            <h4>{post.title}</h4>
            <p>{post.body}</p>
          </div>
        ))}
      </div>
    );
  }
}

export default Posts;

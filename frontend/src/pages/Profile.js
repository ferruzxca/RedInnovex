import React from 'react';
import { useParams } from 'react-router-dom';

function Profile() {
  const { username } = useParams();

  return (
    <div>
      <h1>Profile of {username}</h1>
      {/* TODO: load and display user posts */}
    </div>
  );
}

export default Profile;

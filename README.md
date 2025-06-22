# InnovexMedia

This repository contains a simple skeleton for a social network application with a Spring Boot backend and a React frontend.

## Project Structure

```
backend/     # Spring Boot API
frontend/    # React application
 database/   # SQL schema
```

The SQL schema in `database/schema.sql` follows the tables given in the instructions and stores post images in a `LONGBLOB` column.

## Running the Backend

1. Create a MySQL database named `innovexmedia` and adjust credentials in `backend/src/main/resources/application.properties`.
2. From the `backend` folder run `mvn spring-boot:run`.
3. The API will be available at `http://localhost:8080`.

## Running the Frontend

1. Inside `frontend` run `npm install` to install dependencies.
2. Run `npm start` to start the development server on `http://localhost:3000`.

The frontend contains basic React files ready to be extended with login, feed and profile pages styled in a cyberpunk theme.

## Post Images in Database

The database schema includes an `image_data` LONGBLOB column inside the `posts` table. The backend stores the uploaded image bytes into this column when creating a post.

```java
@PostMapping("/api/posts")
public Post createPost(@RequestParam("image") MultipartFile image,
                       @RequestParam("caption") String caption,
                       Authentication auth) throws IOException {
    User user = userService.getCurrentUser(auth);
    Post post = new Post();
    post.setUser(user);
    post.setCaption(caption);
    post.setImageData(image.getBytes());
    return postRepository.save(post);
}
```

The `Post` entity defines the field as:

```java
@Lob
@Column(name = "image_data", nullable = false)
private byte[] imageData;
```

Retrieve the image using a dedicated endpoint that writes the byte array to the HTTP response with `MediaType.IMAGE_JPEG_VALUE` (or the appropriate type).

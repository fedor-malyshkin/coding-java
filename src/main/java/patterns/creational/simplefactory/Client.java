package patterns.creational.simplefactory;

class Client {

  static void main(String[] args) {
    Post post = PostFactory.createPost("news");
    System.out.println(post);

  }

}
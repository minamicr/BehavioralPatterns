package br.com.cod3r.template.persist.model;

public class UserModel extends ModelPersist{
  private String userName;
  private String password;

  public UserModel(String userName, String password){
    this.userName = userName;
    this.password = password;
  }

  @Override
  protected void preSave() {
    System.out.println("Checking if there is another user with the same username");

  }

  @Override
  protected void prePersist(){
    if(userName == null) throw new RuntimeException("Username is mandatory.");
    if(password == null) throw new RuntimeException("password is mandatory.");
  }

  @Override
  protected void postSave() {
    super.postSave();
    System.out.println("Post save user -> Creating user rules");
  }
}

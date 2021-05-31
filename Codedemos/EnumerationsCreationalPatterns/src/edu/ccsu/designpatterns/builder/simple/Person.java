package edu.ccsu.designpatterns.builder.simple;

public class Person {

  private final String first;   //required
  private final String last;    //required
  private final MaritalStatus maritalStatus;  //optional
  private final String significantOtherName;  //required if married
  private final Double height;        //optional
  private final String jobTitle;      //optional


  private Person(PersonBuilder builder) {
    this.first = builder.first;
    this.last = builder.last;
    this.maritalStatus = builder.maritalStatus;
    this.significantOtherName = builder.significantOtherName;
    this.height = builder.height;
    this.jobTitle = builder.jobTitle;
  }

  public String getFirst() {
	return first;
}

public String getLast() {
	return last;
}

public MaritalStatus getMaritalStatus() {
	return maritalStatus;
}

public String getSignificantOtherName() {
	return significantOtherName;
}

public Double getHeight() {
	return height;
}

public String getJobTitle() {
	return jobTitle;
}

public String toString() {
	StringBuilder stringBuilder = new StringBuilder("Person("+first+" "+last);
	if (jobTitle !=null) {
		stringBuilder.append(" jobTitle="+jobTitle);
	}
	if (height != null) {
		stringBuilder.append(" height="+height);
	}
	if (maritalStatus!=null) {
		stringBuilder.append(" maritalStatus="+maritalStatus);
		if (maritalStatus.equals(MaritalStatus.MARRIED)) {
			stringBuilder.append(" signifantOther="+significantOtherName);
		}
	}
	return stringBuilder.toString()+")";
}

public static class PersonBuilder {
    // required parameters
    private String first = null;
    private String last = null;
    // optional parameters
    private MaritalStatus maritalStatus = null;
    private String significantOtherName = null;
    private Double height = null;
    private String jobTitle = null;

    public PersonBuilder(String first, String last){
      this.first = first;
      this.last = last;
    }

    public Person buildPerson(){
      if (!builderComplete()){
        throw new RuntimeException("Illegal person state");
      }
      return new Person(this);
    }

    public boolean builderComplete(){
      if ((first!=null)&&(last!=null)){
        if (maritalStatus==null){
          return true;
        }else if(!maritalStatus.equals(MaritalStatus.MARRIED)){
          return true;
        }else if(significantOtherName!=null){
          return true;
        }
      }
      return false;
    }

    public PersonBuilder setMaritialStatus(MaritalStatus maritialStatus){
      this.maritalStatus = maritialStatus;
      return this;
    }
    /**
     * @param height the height to set
     */
    public PersonBuilder setHeight(Double height) {
      this.height = height;
      return this;
    }

    /**
     * @param jobTitle the jobTitle to set
     */
    public PersonBuilder setJobTitle(String jobTitle) {
      this.jobTitle = jobTitle;
      return this;
    }

    /**
     * @param significantOtherName the significantOtherName to set
     */
    public PersonBuilder setSignificantOtherName(String significantOtherName) {
      this.significantOtherName = significantOtherName;
      return this;
    }
  }
}

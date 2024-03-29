public class HeartTransplant

{

private Person[] listOfPatients;
// SurvivabilityByAge array, each rate is read from data file
private SurvivabilityByAge[] survivabilityByAge;
// SurvivabilityByCause array, each rate is read from data file
private SurvivabilityByCause[] survivabilityByCause;

public HeartTransplant()
{


this.survivabilityByAge = null;

this.listOfPatients = null;

this.survivabilityByCause = null;

}

*/

public int addPerson(Person p, int arrayIndex)

{

if(listOfPatients.length>arrayIndex)

{

listOfPatients[arrayIndex]=p;

return 0;
}

else

{

return -1;

}

}
/*

* 1) Creates the listOfPatients array with numberOfLines length.

*

* 2) Reads from the command line data file.

* File Format: ID, Ethinicity, Gender, Age, Cause, Urgency, State of health

* Each line refers to one Person.

*

* 3) Inserts each person from file into listOfPatients

* Hint: uses addPerson() method

*

* Returns the number of patients read from file

*/

public int readPersonsFromFile(int numberOfLines)

{

try

{

//the file to be opened for reading

FileInputStream fis=new FileInputStream("data.txt");

Scanner sc=new Scanner(fis); //file to be scanned

//returns true if there is another line to read

String pdata;

int cnt=0;

while(sc.hasNextLine())

{

pdata=sc.nextLine(); //returns the line that was skipped

// assuming values are "," seperated

int[] pd=new int[7];

int i=0;

for (String s : pdata.split(","))

{

pd[i]=Integer.parseInt(s);

i+=1;

}

if(this.addPerson(new Person(pd[0],pd[1],pd[2],pd[3],pd[4],pd[5],pd[6]), cnt)==1)

cnt+=1;

}

sc.close(); //closes the scanner 4

return cnt;

}

catch(IOException e)

{

e.printStackTrace();

}

}

public class Person
{

//Heart Condition Cause Code

public static final int CAUSE_VIRAL = 0;

public static final int CAUSE_CONGENITAL = 1;

public static final int CAUSE_ACCIDENT = 2;

public static final int CAUSE_HEART_ARTERY_DISEASE = 3;

public static final int CAUSE_HEART_MUSCLE_DISEASE = 4;

// State Of Health Code. Health is independent of heart.

public static final int HEALTH_POOR = 5;

public static final int HEALTH_GOOD = 6;

public static final int HEALTH_EXCELLENT = 7;

// Urgency Code

public static final int URGENCY_EXTREME = 8;

public static final int URGENCY_MODERATE = 9;

// Ethnicity Code

public static final int ETHNICITY_AFRICAN_AMERICAN = 10;

public static final int ETHNICITY_CAUCASIAN = 11;

public static final int ETHNICITY_HISPANIC = 12;

// Gender Code

public static final int GENDER_FEMALE = 13;

public static final int GENDER_MALE = 14;

// Instance variables or fields

private int id; // unique identification of the person

private int ethnicity;

private int gender;

private int age;

private int cause;

private int stateOfHealth;

private int urgency;

public Person (int id, int ethnicity, int gender, int age, int cause, int urgency, int stateOfHealth) {

this.id = id; // unique identification of this person

this.ethnicity = ethnicity;

this.gender = gender;

this.age = age;

this.cause = cause;

this.urgency = urgency;

this.stateOfHealth = stateOfHealth;

}

/*

* Returns the Person's age

*/

public int getAge() {

return age;

}

/*

* Returns the Person's ethinicity

*/

public int getEthnicity() {

return ethnicity;

}

/*

* Returns the Person's gender

*/

public int getGender() {

return gender;

}

/*

* Returns the Person's cause for the heart condition

*/

public int getCause() {

return cause;

}

/*

* Returns the Person's urgency for the transplant

*/

public int getUrgency() {

return urgency;

}

/*

* Returns the Person's state of health

*/

public int getStateOfHealth() {

return stateOfHealth;

}

/*

* Returns the string representation of the Person

*/

public String toString()

{

String ret = "" + id;

if (ethnicity == ETHNICITY_AFRICAN_AMERICAN) {

ret += ", african american";

} else if (ethnicity == ETHNICITY_CAUCASIAN) {

ret += ", caucasian";

} else {

ret += ", hispanic";

}

ret += (gender == GENDER_FEMALE) ? ", female" : ", male";

ret += ", " + age;

if (cause == CAUSE_ACCIDENT) {

ret += ", accident";

} else if ( cause == CAUSE_CONGENITAL) {

ret += ", congenital";

} else if ( cause == CAUSE_HEART_ARTERY_DISEASE) {

ret += ", heart artery disease";

} else if ( cause == CAUSE_HEART_MUSCLE_DISEASE) {

ret += ", heart muscle disease";

} else {

ret += ", viral";

}

if (urgency == URGENCY_EXTREME)

{

ret += ", extreme";

}

else

{

ret += ", moderate";

}

if (stateOfHealth == HEALTH_EXCELLENT)

{

ret += ", excellent";

}

else if (stateOfHealth == HEALTH_GOOD)

{

ret += ", good";

}

else

{

ret += ", poor";

}

return ret;

}

}

}
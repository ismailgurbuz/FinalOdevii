import java.util.List;

public class CvModel {
    private String fullName;
    private String title;
    private String email;
    private String phone;
    private String location;
    private String summary;
    private List<String> experiences;
    private List<String> education;
    private List<String> skills;
    private String photoPath;

    public CvModel(String fullName, String title, String email, String phone, String location, 
                   String summary, List<String> experiences, List<String> education, 
                   List<String> skills, String photoPath) {
        this.fullName = fullName;
        this.title = title;
        this.email = email;
        this.phone = phone;
        this.location = location;
        this.summary = summary;
        this.experiences = experiences;
        this.education = education;
        this.skills = skills;
        this.photoPath = photoPath;
    }

    public String getFullName() { return fullName; }
    public String getTitle() { return title; }
    public String getEmail() { return email; }
    public String getPhone() { return phone; }
    public String getLocation() { return location; }
    public String getSummary() { return summary; }
    public List<String> getExperiences() { return experiences; }
    public List<String> getEducation() { return education; }
    public List<String> getSkills() { return skills; }
    public String getPhotoPath() { return photoPath; }
}
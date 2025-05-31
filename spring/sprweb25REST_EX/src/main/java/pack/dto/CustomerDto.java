package pack.dto;

public class CustomerDto {
    private int gogekNo;
    private String name;
    private String tel;

    public CustomerDto(int gogekNo, String name, String tel) {
        this.gogekNo = gogekNo;
        this.name = name;
        this.tel = tel;
    }

    public int getGogekNo() { return gogekNo; }
    public String getName() { return name; }
    public String getTel() { return tel; }
}

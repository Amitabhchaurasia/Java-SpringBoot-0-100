package com.week2.work.week2work.DTO;
import java.time.LocalDate;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentDto {
    private long id;
    private String title;
    private boolean active;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate createdAt;
}

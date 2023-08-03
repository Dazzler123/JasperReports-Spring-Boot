/**
 * #=== Created by Dazzler7Soft.Eng.Udg ===#
 * Date : 03-Aug-2023
 * Time : 12:23 PM
 * Project Name : JasperReports-Spring-Boot
 */
package lk.dazzler.devo.java.spring.jasper.reports.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class CustomerDTO {
    private String id;
    private String name;
    private int age;
    private String address;
}

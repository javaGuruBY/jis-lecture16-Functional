package by.jrr.stream.realcase;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TShapeEmployee {

    private String name;
    private Map<String, Integer> skillMap = new HashMap<>();
}

package nazarov.stetsyuk.steps;

import java.util.HashMap;
import java.util.Map;

public class BaseSteps {

    public static Map<String, String> variables = new HashMap<>();

    public String checkVariable(String variable){
        if(variable.startsWith("%{") && variable.endsWith("}%")) {
            variable = variable.replaceAll("(^.{2})", "");
            variable = variable.replaceAll("(.{2}$)", "");
            for (Map.Entry<String, String> entry : variables.entrySet()) {
                if (entry.getKey().equals(variable)) {
                    variable = entry.getValue();
                    break;
                }
            }
        }
        return variable;
    }
}

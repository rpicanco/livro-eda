import { PutRuleCommand } from "@aws-sdk/client-eventbridge";
import { GetRoleCommand } from "@aws-sdk/client-iam";
import { iAMClient } from "./iamClient.js";
import { ebClient } from "./eventBridgeClient.js";

const INTEGRATION_ASSUME_ROLE = "IntegrationAssumeRole";

const GetRoleCommandInput = { 
  RoleName: INTEGRATION_ASSUME_ROLE,
};

async function createRule(input) {   

  try {
    
    const GetRoleCommandResult = await iAMClient.send(new GetRoleCommand(GetRoleCommandInput));

    if(GetRoleCommandResult == null) {
      throw new Error(`A role "${GetRoleCommandInput}" não existe!!!`);
    }

    const eventPattern = "{\"detail\": {\"merchantId\": [\"XXX\"]}}".replace("XXX", input.merchantId);

    const PutRuleCommandInput = {  
      Name: input.name,
      RoleArn: GetRoleCommandResult.Arn,
      State: "ENABLED",
      EventPattern: eventPattern,
    };

    const result = await ebClient.send(new PutRuleCommand(PutRuleCommandInput));
    return result;

  } catch (err) {
    console.log("Error", err);
  }
};

export { createRule };
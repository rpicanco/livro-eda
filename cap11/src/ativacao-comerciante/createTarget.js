import { PutTargetsCommand } from "@aws-sdk/client-eventbridge";
import { ebClient } from "./eventBridgeClient.js";
import { createRole } from "./createRole.js";

async function createTarget(input) {  

  try {

    const createRoleInput = {
      apiDestinationName: input.apiDestinationName,      
      merchantId: input.merchantId,
  };

    const roleArn = await createRole(createRoleInput);

    const PutTargetsInput = {
      Rule: input.ruleName,
      Targets: [
          {
            Arn: input.apiDestinationArn,
            Id: input.merchantId + "-apidestination-target",
            RoleArn: roleArn,
          },
      ]    
  };
    
  const result = await ebClient.send(new PutTargetsCommand(PutTargetsInput));
  return result;

  } catch (err) {
    console.log("Error", err);
  }
}

export { createTarget };
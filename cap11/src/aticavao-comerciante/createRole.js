import { CreateRoleCommand, CreatePolicyCommand, AttachRolePolicyCommand } from "@aws-sdk/client-iam";
import { iAMClient } from "./iamClient.js";

const REGION = process.env.AWS_REGION;
const ACCOUNT_NUMBER = process.env.AWS_ACCOUNT_NUMBER;

async function createRole(input) {  
    
    const roleName = "Merchant-" + input.merchantId + "-invocationRole";

    const CreateRoleCommandInput = { 
        RoleName: roleName,
        AssumeRolePolicyDocument: JSON.stringify({
            Version: "2012-10-17",
            Statement: [
              {
                Effect: "Allow",
                Principal: {
                  Service: "events.amazonaws.com",
                },
                Action: "sts:AssumeRole",
              },
            ],
          }),
        Description: "Para invocar o endpoint HTTPS do merchant",      
      };

    const policyName = "Merchant-" + input.merchantId + "-invocationPolicy";

    const ACTION = "events:InvokeApiDestination";

    const RESOURCE = "arn:aws:events:" + REGION + ":" + ACCOUNT_NUMBER + ":api-destination/" + input.apiDestinationName + "/*";

    const createPolicyInput = { 
       PolicyName: policyName, 
       PolicyDocument: JSON.stringify({
        Version: "2012-10-17",
        Statement: [
          {
            Effect: "Allow",
            Action: [ACTION],
            Resource: [RESOURCE],
          },
        ],
      }), 
    };    

      try {

        const CreateRoleCommandResult = await iAMClient.send(new CreateRoleCommand(CreateRoleCommandInput));

        if(CreateRoleCommandResult == null) {
            throw new Error(`Erro inesperado ao criar a role "${CreateRoleCommandInput}"!!!`);
        }

        console.log("Role status : ", (CreateRoleCommandResult != null) ? "[SUCESSO]" : "[ERRO]");        

        const CreatePolicyCommandResult = await iAMClient.send(new CreatePolicyCommand(createPolicyInput));

        if(CreatePolicyCommandResult == null) {
            throw new Error(`Erro inesperado ao criar a policy "${createPolicyInput}"!!!`);
        }

        console.log("Policy status : ", (CreatePolicyCommandResult != null) ? "[SUCESSO]" : "[ERRO]");

        const attachRolePolicyInput = {
            RoleName: roleName, 
            PolicyArn: CreatePolicyCommandResult.Policy.Arn,
        };

        const attachRolePolicyResult = await iAMClient.send(new AttachRolePolicyCommand(attachRolePolicyInput));

        if(attachRolePolicyResult == null) {
            throw new Error(`Erro inesperado ao criar a policy "${attachRolePolicyInput}"!!!`);
        }

        console.log("Policy associada a role status : ", (attachRolePolicyResult != null) ? "[SUCESSO]" : "[ERRO]");
   
        return CreateRoleCommandResult.Role.Arn;

      } catch (err) {
        console.log("Error", err);
      }    
}

export { createRole };
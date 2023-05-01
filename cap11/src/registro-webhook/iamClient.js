import { IAMClient } from "@aws-sdk/client-iam";

const REGION = process.env.AWS_REGION;
const iAMClient = new IAMClient({ region: REGION });
export { iAMClient };
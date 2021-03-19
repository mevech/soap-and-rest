## Create iam credential for github action

the purpose of setting up github action is to build docker container and upload to ECR
I will use aws cli for this. since it is cooler

### creating a group
```aws iam create-group --group-name CI-github-action ```


### creating policies

**use console**

- create a policy with name minimum-policy with json in `minimum-policy.json`
- creaet a policy with name ecr-pull-push with json in `ecr-pull-push.json`

you can use ```aws iam list-policies``` to check if the policy has been successfully created

### attaching policy to the group
``` shell
aws iam attach-group-policy \
--group-name CI-github-action \ 
--policy-arn arn:aws:iam::${ACCOUNT_ID}:policy/ecr-pull-push
```
```
aws iam attach-group-policy \
--group-name CI-github-action \ 
--policy-arn arn:aws:iam::${ACCOUNT_ID}:policy/minimum-policy
```

*check*

```
aws iam list-attached-group-policies \
--group-name CI-github-action
```
### create user in group
```shell
aws iam create-user --user-name soap-and-rest --path "/CI"
```
I added a path so it is eaisier to manage later
```shell
aws iam add-user-to-group --user-name soap-and-rest \
--group-name CI-github-action
```
### create secret key
```shell
aws iam create-access-key --user-name soap-and-rest
```
in the json response: 
```shell
{
    "AccessKey": {
        "UserName": "soap-and-rest",
        "AccessKeyId": "${KEY_ID}",
        "Status": "Active",
        "SecretAccessKey": "${SECRET}",
        "CreateDate": "2021-03-02T11:03:26+00:00"
    }
}
```

get the `${KEY_ID}` and `${SECRET}` and use them in github action
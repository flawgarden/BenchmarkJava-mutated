# Since Docker doesn't auto delete anything, just like for the Ubuntu update, delete any existing benchmark-mutated:latest image before building a new one
docker image rm benchmark-mutated:latest
docker build -t benchmark-mutated .

import matplotlib.pyplot as plt
import matplotlib.ticker as mticker
import csv
from collections import defaultdict


def read_csv(filename):
    data = defaultdict(list)
    with open(filename, 'r') as f:
        reader = csv.DictReader(f, delimiter=';')
        headers = [h.strip('"') for h in reader.fieldnames if h.lower().strip('"') != 'size']
        for row in reader:
            try:
                size = int(row['Size'].strip('"'))
            except (ValueError, KeyError):
                continue
            for header in headers:
                val_str = row.get(header) or row.get(f'"{header}"') or ''
                try:
                    val = int(val_str.strip('"'))
                except ValueError:
                    val = 0
                data[header].append((size, val))
    return data


# Load data from CSV
filename = 'CustomDoublyLinkedList_performance.csv'
custom_data = read_csv(filename)

methods = sorted(custom_data.keys())
sizes = sorted([size for size, _ in custom_data[methods[0]]])  # Assume all methods share size steps
x_max = max(sizes)
x_min = 10000

# Create figure with one subplot per method
fig, axes = plt.subplots(nrows=len(methods), ncols=1, figsize=(10, 4 * len(methods)))
if len(methods) == 1:
    axes = [axes]

# Generate x-ticks from 10000 to x_max in 100000 increments
x_ticks = list(range(x_min, x_max + 1, 100000))

for idx, method in enumerate(methods):
    ax = axes[idx]
    times = [time for _, time in custom_data[method]]

    ax.plot(sizes, times, linestyle='-', linewidth=1.5)
    ax.set_title(method)
    ax.set_xlabel('Input Size')
    ax.set_ylabel('Time (ns)')
    ax.grid(True)

    y_max = max(times, default=1)

    ax.set_xlim(x_min, x_max)
    ax.set_ylim(0, y_max * 1.1)
    ax.set_xticks(x_ticks)
    ax.set_xticklabels([f"{tick:,}" for tick in x_ticks], rotation=45, ha='right')
    ax.xaxis.set_major_formatter(mticker.FuncFormatter(lambda x, _: f"{int(x):,}"))
    ax.yaxis.set_major_formatter(mticker.ScalarFormatter())

plt.tight_layout()
plt.savefig('CustomDoublyLinkedList_Performance_Charts.png', dpi=300, bbox_inches='tight')
plt.close()

print(f"Charts saved as 'CustomDoublyLinkedList_Performance_Charts.png' for {len(methods)} methods.")
